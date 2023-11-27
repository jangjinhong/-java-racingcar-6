package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String DISPLAY_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String DISPLAY_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";


    public static String displayCarNamesMessage() {
        System.out.println(DISPLAY_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }
    public static String displayMoveCountMessage() {
        System.out.println(DISPLAY_MOVE_COUNT_MESSAGE);
        return Console.readLine();
    }
}