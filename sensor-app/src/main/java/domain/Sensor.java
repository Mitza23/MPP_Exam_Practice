package domain;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Sensor {
    int id;
    String name;
    int lowerBound;
    int upperBound;

    public Sensor(int id, String name, int lowerBound, int upperBound) {
        this.id = id;
        this.name = name;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int measure() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Random().nextInt(upperBound - lowerBound) + lowerBound;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }
}
