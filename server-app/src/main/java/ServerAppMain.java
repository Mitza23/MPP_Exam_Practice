import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tcp.ApplicationServer;

public class ServerAppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("config");
        ApplicationServer server = context.getBean(ApplicationServer.class);

        server.start();
    }
}
