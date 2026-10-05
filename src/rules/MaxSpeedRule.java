package rules;

import model.CarType;
import model.Observation;
import model.Violation;

import java.util.Optional;

public class MaxSpeedRule implements Rule {
    private final CarType carType;
    private final int maxAllowedSpeed;
    private final int fee;

    public MaxSpeedRule(CarType carType, int maxAllowedSpeed, int fee) {
        this.carType = carType;
        this.maxAllowedSpeed = maxAllowedSpeed;
        this.fee = fee;
    }

    @Override
    public Optional<Violation> check(Observation observation) {

        if (observation.getCarType() != carType) {
            return Optional.empty();
        }

        if (observation.getSpeed() <= maxAllowedSpeed) {
            return Optional.empty();
        }


        String description = String.format(
                "Speed of %d exceeded max allowed %d",
                observation.getSpeed(),
                maxAllowedSpeed
        );

        return Optional.of(new Violation(description, fee));

    }

    @Override
    public String getRuleName() {
        return "Speed";
    }
}
