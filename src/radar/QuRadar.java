package radar;

import model.Fine;
import model.Observation;
import model.Violation;
import rules.Rule;

import java.util.*;

/**
 * Quantum Radar System
 *
 * This system receives vehicle observations from a radar including:
 * plate number, date, car type, speed, and seatbelt status.
 *
 * Each observation is checked against a set of traffic rules.
 * If one or more rules are violated, the system creates a fine
 * containing all violations and their corresponding fees.
 *
 * The system is designed to be extensible, allowing new rules to be
 * added without modifying the QuRadar class.
 *
 * Technologies & Design:
 * - Java
 * - Object-Oriented Programming (OOP)
 * - SOLID Principles
 * - Strategy Design Pattern
 * - Java Collections (ArrayList, HashMap)
 *
 * AI Model Used:
 * The physical radar uses a CNN-based ANPR model to read license plates
 * and a CNN model to identify the vehicle type.
 * QuRadar receives the extracted data and applies traffic rules only.
 *
 */

public class QuRadar {

    private final List<Rule> rules = new ArrayList<>();
    private final List<Fine> fines = new ArrayList<>();
    private final Map<String, Integer> violatedRulesCount = new HashMap<>();


    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void observe(Observation observation) {
        List<Violation> violations = new ArrayList<>();
        for (Rule rule : rules) {
            Optional<Violation> result = rule.check(observation);
            if (result.isPresent()) {
                Violation violation = result.get();
                violations.add(violation);
                String ruleName = rule.getRuleName();
                violatedRulesCount.put(
                        ruleName,
                        violatedRulesCount.getOrDefault(ruleName, 0) + 1
                );
            }
        }

        if (!violations.isEmpty()) {
            Fine fine = new Fine(observation.getPlateNumber(), violations);

            fines.add(fine);

            fine.print();

            System.out.println();

        }

    }


    public List<Fine> getAllPossibleFines() {
        return fines;
    }

    public Map<String, Integer> getViolatedRulesCount() {
        return violatedRulesCount;
    }


}
