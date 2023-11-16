package christmas.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageJoinerTest {

    @DisplayName("join 테스트")
    @Nested
    class join {

        @DisplayName("빈 배열이 입력되면 \"없음\"을 반환한다.")
        @Test
        void givenListIsEmpty() {
            assertEquals(MessageJoiner.join(List.of()), "없음");
        }

        @DisplayName("문자열이 입력되면 delimiter를 개행으로 하고 합친다.")
        @Test
        void givenListIsNotEmpty() {
            assertEquals(MessageJoiner.join(List.of("A", "B")), "A\nB");
        }

    }

}