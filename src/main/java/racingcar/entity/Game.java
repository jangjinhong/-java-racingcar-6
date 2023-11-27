package racingcar.entity;

import java.util.ArrayList;

public class Game {
    private int moveCount;
    private ArrayList<Car> cars;
    //private Car[] cars;

    public Game(ArrayList<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
