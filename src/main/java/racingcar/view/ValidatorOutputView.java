package racingcar.view;

public class ValidatorOutputView {
    static final String NOT_FIVE_OR_LESS_ERROR_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
    static final String  RETRY_INPUT_CAR_NAMES_MESSAGE = "자동차 이름을 2개 이상 작성해주세요.";
    static public void NotFiveorLessErrorMessage() {
        System.out.println(NOT_FIVE_OR_LESS_ERROR_MESSAGE);
    }
}
