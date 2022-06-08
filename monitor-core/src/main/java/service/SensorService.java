package service;

import dto.SensorName;
import entities.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SensorRepository;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    SensorRepository repository;

    public List<Sensor> getAll() {
        return repository.findAll();
    }

    public List<SensorName> getNames() {
        return repository.findDistinctByNameContaining("");
//        return repository.findAllByNameContaining("");
    }

}
