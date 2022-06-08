package service;

import com.google.gson.Gson;
import domain.Message;
import domain.Sensor;
import domain.SensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Service
public class SensorService extends BaseService{

    Sensor sensor;

    @Autowired
    public SensorService(ExecutorService executorService, Client client) {
        super(executorService, client);
    }

    public Future<Boolean> measure() {
        return executorService.submit(() -> {
            SensorDTO entity = new SensorDTO(sensor.getId(), sensor.getName(), sensor.measure());
            Message request = new Message("get-reading", new Gson().toJson(entity));

            Message response = this.client.sendAndReceive(request);

            return response.getHeader().equals(Message.OK);
        });
    }

    public void addSensor(int id, String name, int lowerBound, int upperBound) {
        sensor = new Sensor(id, name, lowerBound, upperBound);
    }

}
