package rules;

import model.Observation;
import model.Violation;

import java.util.Optional;

public class SeatbeltRule implements Rule{

    private static final int FEE = 100;
    @Override
    public Optional<Violation> check(Observation observation) {
        if(observation.isSeatbeltFastened()){
            return Optional.empty();
        }

        return Optional.of(
                new Violation("Seatbelt not fastened", FEE)
        );

    }

    @Override
    public String getRuleName() {
        return "Seatbelt";
    }

}
