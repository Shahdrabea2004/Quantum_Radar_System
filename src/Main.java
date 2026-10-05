import model.CarType;
import model.Fine;
import model.Observation;
import radar.QuRadar;
import rules.MaxSpeedRule;
import rules.SeatbeltRule;

import java.time.LocalDate;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        QuRadar radar = new QuRadar();

        // Add Rules
        radar.addRule(new MaxSpeedRule(CarType.PRIVATE, 80, 300));
        radar.addRule(new MaxSpeedRule(CarType.TRUCK, 60, 300));
        radar.addRule(new MaxSpeedRule(CarType.BUS, 60, 300));
        radar.addRule(new SeatbeltRule());

        // Observation 1
        Observation car1 = new Observation(
                "ABC1234",
                LocalDate.now(),
                CarType.PRIVATE,
                94,
                false
        );

        // Observation 2
        Observation car2 = new Observation(
                "XYZ5555",
                LocalDate.now(),
                CarType.TRUCK,
                65,
                true
        );

        // Observation 3
        Observation car3 = new Observation(
                "BUS1001",
                LocalDate.now(),
                CarType.BUS,
                55,
                false
        );

        // Observation 4
        Observation car4 = new Observation(
                "BUS100",
                LocalDate.now(),
                CarType.BUS,
                55,
                true
        );

        // Process observations
        radar.observe(car1);
        radar.observe(car2);
        radar.observe(car3);
        radar.observe(car4);

        // Print all fines
        System.out.println("===== All Possible Fines =====");

        for (Fine fine : radar.getAllPossibleFines()) {
            System.out.println(
                    fine.getPlateNumber() +
                            " -> " +
                            fine.getTotalAmount() +
                            " EGP"
            );
        }

        // Print violated rules count
        System.out.println("\n===== Violated Rules Count =====");

        for (Map.Entry<String, Integer> entry : radar.getViolatedRulesCount().entrySet()) {
            System.out.println(
                    entry.getKey() +
                            " : " +
                            entry.getValue()
            );
        }
    }
}