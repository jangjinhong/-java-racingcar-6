package racingcar.entity;

public class Car {
    static final String HYPHEN = "-";

    private String CarName;
    private String movementStatus = "";

    public Car(String CarName) {
        this.CarName = CarName;
    }

    public String getCarName() {
        return CarName;
    }

    public String getMovementStatus() {
        return movementStatus;
    }

    public void addMovementStatus() {
        this.movementStatus += HYPHEN;
    }
}