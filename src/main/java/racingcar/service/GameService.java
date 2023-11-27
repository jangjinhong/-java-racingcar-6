package racingcar.service;

import racingcar.entity.Car;
import racingcar.entity.Game;
import racingcar.view.OutputView;
import racingcar.view.ValidatorOutputView;

import java.util.ArrayList;
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

    // 예외 처리 여부 판별
    public String[] promptForStringCarNames(String stringCarNames) {
        String[] arrCarNames = stringCarNames.split(",");
        if(!checkOrLess(arrCarNames) || !checkUniqueCarNames(arrCarNames)) {
            ValidatorOutputView.NotFiveorLessErrorMessage();
            throw new IllegalArgumentException();
        }
        return arrCarNames;
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

    /* ---- 예외처리 함수 ---- */
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

    private boolean checkUniqueCarNames(String[] carNames) {
        Set<String> carNamesSet = new HashSet<>();
        for(int i=0; i<carNames.length; i++)
            carNamesSet.add(carNames[i]);

        if(carNamesSet.size() != carNames.length)
            return false;
        return true;
    }
}