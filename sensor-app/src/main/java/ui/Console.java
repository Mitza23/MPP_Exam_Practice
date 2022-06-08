package ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.SensorService;

import java.util.Scanner;

@Component
public class Console {
    @Autowired
    private SensorService service;

    private Scanner scanner = new Scanner(System.in);

    private void printMenu() {
        System.out.println(
            """
            1. Add sensor
            2. Measure
            0. Exit
            """
        );
    }

    private void addSensor() {
        System.out.print("ID >>");
        int id = scanner.nextInt();
        System.out.print("name >>");
        String name = scanner.next();
        System.out.print("lower-bound >>");
        int lb = scanner.nextInt();
        System.out.print("upper-bound >>");
        int ub = scanner.nextInt();
        service.addSensor(id, name, lb, ub);
    }

    private void measure() {
        while (true) {
            service.measure();
        }
    }

    public void mainLoop() {
        boolean done = false;
        while (!done) {
            printMenu();
            int cmd = scanner.nextInt();
            switch (cmd){
                case 1: addSensor();
                break;
                case 2: measure();
                break;
                case 0: done = true;
                break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
