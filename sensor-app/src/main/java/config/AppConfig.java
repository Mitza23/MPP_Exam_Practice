package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.Client;
import service.SensorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@ComponentScan({"ui", "service"})
public class AppConfig {

    @Bean
    SensorService sensorService() {
        return new SensorService(executorsService(), client());
    }

    @Bean
    public Client client() {
        return new Client("localhost", 5000);
    }
    @Bean
    public ExecutorService executorsService() {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
}
