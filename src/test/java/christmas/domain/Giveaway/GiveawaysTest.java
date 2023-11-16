package christmas.domain.Giveaway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiveawaysTest {

    @DisplayName("getGiveawayMessage 테스트")
    @Nested
    class getGiveawayMessage {

        @DisplayName("리스트가 비어 있으면 \"없음\"을 반환한다..")
        @Test
        void givenListIsEmpty() {
            Giveaways giveaways = new Giveaways(List.of());
            assertEquals(giveaways.getGiveawayMessage(), "없음");
        }

        @DisplayName("메시지를 정상적으로 출력하는지 확인한다.")
        @Test
        void checkGetGiveawayMessage() {
            Giveaways giveaways = new Giveaways(List.of(new Giveaway("메시지", 1)));
            assertEquals(giveaways.getGiveawayMessage(), "메시지 1개");
        }

    }

}