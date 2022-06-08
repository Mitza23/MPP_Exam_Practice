package repository;

import dto.SensorName;
import entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    List<SensorName> findDistinctByNameContaining(String s);

    List<SensorName> findAllByNameContaining(String s);
}
