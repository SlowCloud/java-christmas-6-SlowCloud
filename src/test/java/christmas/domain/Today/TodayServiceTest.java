package christmas.domain.Today;

import christmas.constant.ExceptionMessage;
import christmas.domain.Today.TodayService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TodayServiceTest {

    private static TodayService todayService;

    @BeforeAll
    private static void setup() {
        todayService = new TodayService();
    }

    @DisplayName("createToday 테스트")
    @Nested
    class createToday {

        @DisplayName("입력이 숫자가 아니면 오류를 반환한다.")
        @Test
        void givenStringIsNotNumber() {
            Assertions.assertThatThrownBy(() -> todayService.createToday("하나"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_TODAY_MESSAGE);
        }

        @DisplayName("숫자 범위가 1에서 31 사이가 아니면 오류를 반환한다.")
        @Test
        void givenNumberIsOutOfRange() {
            Assertions.assertThatThrownBy(() -> todayService.createToday("32"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_TODAY_MESSAGE);
        }

    }

}