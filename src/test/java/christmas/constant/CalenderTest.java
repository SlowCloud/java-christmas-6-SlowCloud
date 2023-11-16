package christmas.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CalenderTest {

    @DisplayName("verify 테스트")
    @Nested
    class isDayOfWeek {

        @DisplayName("확인을 제대로 하는지 검사")
        @ParameterizedTest
        @CsvSource(value = {"1,BEFORE_CHRISTMAS", "25,CHRISTMAS", "3,WEEKDAY", "1,WEEKEND", "3,SUNDAY"})
        void checkVerify(int day, String calenderName) {
            assertTrue(Calender.valueOf(calenderName).verify(day));
        }

    }

}