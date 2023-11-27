package racingcar.service;

import racingcar.entity.Car;
import racingcar.entity.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ValidatorOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameService {
    public Game createGame(ArrayList<Car> cars, int moveCount) {
        Game game = new Game(cars, moveCount);
        return game;
    }

    public void getWinner(Game game) {
        OutputView.finalWinnerInfoMessage();
        OutputView.printWinner(calculateWinners(game));
    }

    public ArrayList<String> calculateWinners(Game game) {
        ArrayList<String> winnerCars = new ArrayList<>();
        ArrayList<Car> cars = game.getCars();
        int maxMovementStatus = 0;

        for(Car car : cars) {
            int movementStatusLength = car.getMovementStatus().length();
            if(movementStatusLength > maxMovementStatus) {
                maxMovementStatus = movementStatusLength;
                winnerCars.clear();
            }
            if(movementStatusLength >= maxMovementStatus) {
                winnerCars.add(car.getCarName());
            }
        }
        return winnerCars;
    }


    public String[] promptForStringCarNames(String stringCarNames) {
        String[] arrCarNames = stringCarNames.split(",");
        checkExceptionHandling(arrCarNames);

        if(arrCarNames.length == 1) {
            return handleReEntryForSingleCarName();
        }
        return arrCarNames;
    }

    private String[] handleReEntryForSingleCarName() {
        throw new IllegalArgumentException();
        //OutputView.getRetryInputCarNamesMessage();
        //String retryInput = InputView.displayCarNamesMessage();
        //return promptForStringCarNames(retryInput);
    }

    public Game createGameFromStrings(String[] arrCarNames, String stringMoveCount) {
       int moveCount = convertStringToMoveCount(stringMoveCount);
       return createGame(arrStringToCars(arrCarNames), moveCount);
    }

    /* ---- Convert function ---- */
    public ArrayList<Car> arrStringToCars(String[] arrCarNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for(int i=0; i<arrCarNames.length; i++)
            cars.add(new Car(arrCarNames[i]));
        return cars;
    }
    public int convertStringToMoveCount(String stringMoveCount) {
        return Integer.parseInt(stringMoveCount);
    }

    // 예외 처리 여부 판별
    public boolean checkExceptionHandling(String[] arrCarNames) {
        if(!checkOrLess(arrCarNames) || !checkUniqueCarNames(arrCarNames)) {
            ValidatorOutputView.NotFiveorLessErrorMessage();
            throw new IllegalArgumentException();
        }


        return true;
    }

    /* ---- 예외처리 함수 ---- */
    /*private String checkisItMultipleCars(String[] carNames) {
        if(!isItMultipleCars(carNames))
            return InputView.getRetryInputCarNamesMessage();
        return carNames;
    }
    private String isItMultipleCars(String[] carNames) {
        if(carNames.length == 1)
            return InputView.getRetryInputCarNamesMessage();
    }*/

    private boolean checkUniqueCarNames(String[] carNames) {
        Set<String> carNamesSet = new HashSet<>(Arrays.asList(carNames));
        return carNamesSet.size() == carNames.length;
    }

    private boolean checkOrLess(String[] carNames) {
        for(int i=0; i<carNames.length; i++) {
            if(!isOrLess(carNames[i]))
                return false;
        }
        return true;
    }
    private boolean isOrLess(String carName) {
        if(carName.length() > 5)
            return false;
        return true;
    }
}