package controller;

import dto.NamesListDTO;
import dto.SensorListDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SensorService;

@RestController
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/all")
    SensorListDTO getAll() {
        return new SensorListDTO(sensorService.getAll());
    }

    @GetMapping("/names")
    NamesListDTO getNames() {
        return new NamesListDTO(sensorService.getNames());
    }

}
