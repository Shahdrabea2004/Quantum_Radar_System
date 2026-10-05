package model;

import java.util.List;

public class Fine {

    private String plateNumber;
    private List<Violation>violations;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    public int getTotalAmount() {

        int total = 0;

        for (Violation violation : violations) {
            total += violation.getFee();
        }

        return total;
    }

    public void print() {

        System.out.println("Traffic for car " + plateNumber);
        System.out.println("Total amount: " + getTotalAmount() + " EGP");
        System.out.println("Violations:");

        for (Violation violation : violations) {
            System.out.println("- " +
                    violation.getDescription() +
                    " : " +
                    violation.getFee() +
                    " EGP");
        }

        System.out.println();
    }
}
