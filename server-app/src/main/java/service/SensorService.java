package service;

import domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SensorRepository;

@Service
public class SensorService{
    @Autowired
    private SensorRepository sensorRepository;


    public void persist(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
