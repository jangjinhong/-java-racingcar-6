package racingcar.view;

public class ValidatorOutputView {
    static final String NOT_FIVE_OR_LESS_ERROR_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
    static final String RETRY_INPUT_CAR_NAMES_ERROR_MESSAGE = "자동차 이름을 2개 이상 작성해주세요.";
    static final String NOT_ENTERED_DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    static final String NO_VALUE_ERROR_MESSAGE = "자동차 이름을 입력해주세요.";

    static public String NotFiveorLessErrorMessage() {
        return NOT_FIVE_OR_LESS_ERROR_MESSAGE;
    }
    public static String getRetryInputCarNamesMessage() {
        return RETRY_INPUT_CAR_NAMES_ERROR_MESSAGE;
    }
    public static String NotEnteredDuplicateCarNameErrorMessage() {
        return NOT_ENTERED_DUPLICATE_CAR_NAME_ERROR_MESSAGE;
    }
    public static String NoValueErrorMessage() {
        return NO_VALUE_ERROR_MESSAGE;
    }
}
