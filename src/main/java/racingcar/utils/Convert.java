package racingcar.utils;

import racingcar.entity.Car;

import java.util.ArrayList;

public class Convert {
    /* ---- Convert function ---- */
    public static ArrayList<Car> arrStringToCars(String[] arrCarNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for(int i=0; i<arrCarNames.length; i++)
            cars.add(new Car(arrCarNames[i]));
        return cars;
    }
    public static int convertStringToMoveCount(String stringMoveCount) {
        return Integer.parseInt(stringMoveCount);
    }
}
