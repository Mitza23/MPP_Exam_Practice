package domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private int measurement;
    private long time;

    public Sensor(String name, int measurement, long time) {
        this.name = name;
        this.measurement = measurement;
        this.time = time;
    }

    public Sensor(SensorDTO sensorDTO) {
        this.name = sensorDTO.getName();
        this.measurement = sensorDTO.getValue();
        time = System.currentTimeMillis();
    }
}
