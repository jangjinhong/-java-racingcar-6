package racingcar.service;

import racingcar.entity.Car;
import racingcar.entity.Game;
import racingcar.utils.Convert;
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
        OutputView.printFinalWinnerInfoMessage();
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
        if(arrCarNames.length == 1)
            return handleReEntryForSingleCarName();
        return arrCarNames;
    }

    public Game createGameFromStrings(String[] arrCarNames, String stringMoveCount) {
       int moveCount = Convert.convertStringToMoveCount(stringMoveCount);
       return createGame(Convert.arrStringToCars(arrCarNames), moveCount);
    }


    // 예외 처리 여부 판별
    private boolean checkExceptionHandling(String[] arrCarNames) {
        if(arrCarNames == null) {
            throw new IllegalArgumentException(ValidatorOutputView.NoValueErrorMessage());
        }
        if(!checkOrLess(arrCarNames)) {
            throw new IllegalArgumentException(ValidatorOutputView.NotFiveorLessErrorMessage());
        }
        if(!checkUniqueCarNames(arrCarNames)) {
            throw new IllegalArgumentException(ValidatorOutputView.NotEnteredDuplicateCarNameErrorMessage());
        }
        return true;
    }
    /* ---- 예외처리 함수 ---- */


    private String[] handleReEntryForSingleCarName() {
        throw new IllegalArgumentException(ValidatorOutputView.getRetryInputCarNamesMessage());
    }

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
        for(String carName : carNames)
            carNamesSet.add(carName);
        if(carNamesSet.size() == carNames.length)
            return true;
        return false;
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