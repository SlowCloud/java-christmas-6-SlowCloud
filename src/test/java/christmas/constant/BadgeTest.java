package christmas.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BadgeTest {

    @DisplayName("findBadge 테스트")
    @Nested
    class findBadge {

        @DisplayName("할인액에 따라 알맞은 뱃지를 반환한다.")
        @ParameterizedTest
        @CsvSource(value = {"0,없음", "-5000,별", "-10000,트리", "-20000,산타"}, delimiter = ',')
        void findRightBadge(int discounted, String BadgeName) {
            assertEquals(Badge.findBadge(discounted).getBadgeName(), BadgeName);
        }

    }

    @DisplayName("getBadgeName 테스트")
    @Nested
    class getBadgeName {

        @DisplayName("뱃지 이름을 확인한다.")
        @Test
        void checkGetBadgeName() {
            Badge badge = Badge.STAR;
            assertEquals(badge.getBadgeName(), "별");
        }

    }

}