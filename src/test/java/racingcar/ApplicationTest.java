package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.service.GameService;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        // 무작위로 생성된 숫자가 특정 범위 내에 있는지 확인하는 테스트 메서드 호출
        assertRandomNumberInRangeTest(
            () -> {
                // "pobi,woni" 및 "1" 인수를 사용하여 'run'이라는 메서드를 실행
                run("pobi,woni", "1");
                // 출력에 "pobi"의 움직임과 최종 승자를 나타내는 특정 문자열이 포함되어 있는지 확인
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_길이_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_중복일경우_예외_처리() {
        String duplicateCarName = "Car1,Car2,Car3,Car4,Car4";
        GameService gameService = new GameService();

        assertThrows(IllegalArgumentException.class,
                () -> gameService.promptForStringCarNames(duplicateCarName));
    }

    @Test
    void 이름_1개일경우_예외_처리() {
        String carName = "Car1";
        GameService gameService = new GameService();

        assertThrows(IllegalArgumentException.class,
                () -> gameService.promptForStringCarNames(carName));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
