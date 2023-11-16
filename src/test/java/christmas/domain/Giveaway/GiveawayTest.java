package christmas.domain.Giveaway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiveawayTest {

    @DisplayName("getMessage 테스트")
    @Nested
    class getMessage {

        @DisplayName("메시지를 잘 출력하는지 확인한다.")
        @Test
        void checkGetMessage() {
            Giveaway giveaway = new Giveaway("메시지", 1);
            assertEquals(giveaway.getMessage(), "메시지 1개");
        }

    }

}