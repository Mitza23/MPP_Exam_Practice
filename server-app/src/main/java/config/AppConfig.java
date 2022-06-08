package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.SensorService;
import tcp.ApplicationServer;
import tcp.TcpServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@ComponentScan({"service", "tcp", "repository"})
public class AppConfig {

    @Autowired
    private SensorService sensorService;

    @Bean
    ApplicationServer applicationServer() {
        return new ApplicationServer(executorService(), 5000, sensorService);
    }

    @Bean
    TcpServer tcpServer() {
        return new TcpServer(executorService(), 5000);
    }

    @Bean
    ExecutorService executorService(){
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

}
