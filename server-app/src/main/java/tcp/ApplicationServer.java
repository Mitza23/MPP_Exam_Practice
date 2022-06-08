package tcp;

import com.google.gson.Gson;
import domain.Message;
import domain.Sensor;
import domain.SensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.SensorService;

import java.util.concurrent.ExecutorService;

import static java.lang.Thread.sleep;

@Component
public class ApplicationServer extends TcpServer {

    @Autowired
    private SensorService sensorService;


    public ApplicationServer(ExecutorService executorService, int port, SensorService sensorService) {
        super(executorService, port);
        this.sensorService = sensorService;
        setupHandlers();
        System.out.println("Handlers are all set up: " + getHandlersCount() + " handlers");
    }

    private void setupHandlers() {
        sensorHandlers();
    }

    private void sensorHandlers() {
        addHandler("get-reading", (request) -> {
            SensorDTO sensorDTO = new Gson().fromJson(request.getBody(), SensorDTO.class);
            try {
                sleep(500);
                System.out.println(sensorDTO);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sensorService.persist(new Sensor(sensorDTO.getName(), sensorDTO.getValue(), System.currentTimeMillis()));
            return new Message(Message.OK, "ok");
        });
    }

}
