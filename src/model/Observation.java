package model;
import java.time.LocalDate;

public class Observation {
    private String plateNumber;

    private LocalDate date;

    private CarType carType;

    private int speed;

    private boolean seatbeltFastened;

    public Observation(String plateNumber, LocalDate date, CarType carType, int speed, boolean seatbeltFastened) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isSeatbeltFastened() {
        return seatbeltFastened;
    }

    public void setSeatbeltFastened(boolean seatbeltFastened) {
        this.seatbeltFastened = seatbeltFastened;
    }








}
