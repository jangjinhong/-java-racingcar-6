package racingcar.view;

import racingcar.entity.Car;
import java.util.ArrayList;

public class OutputView {
    static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    static final String OUTPUT_TEMPLATE = " : ";

    public static void executionResultInfoMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }
    public static void printFinalWinnerInfoMessage() {
        System.out.print(FINAL_WINNER_MESSAGE);
    }

    public static void printCarRacingSituation(ArrayList<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getCarName() + OUTPUT_TEMPLATE);
            System.out.println(car.getMovementStatus());
        }
        System.out.println();
    }

    public static void printWinner(ArrayList<String> winnerCars) {
        String result = String.join(", ", winnerCars);
        System.out.println(result);
    }
}