package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Discount.Discounts;
import christmas.domain.Giveaway.Giveaway;
import christmas.domain.Giveaway.Giveaways;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ChampagneGiveawayEventTest {

    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("총 구매액이 12만을 넘지 않으면 null을 반환한다.")
        @Test
        void givenPriceIsLowerThanHundredTwentyThousand() {
            assertNull(ChampagneGiveawayEvent.createInstance(0));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("정상적으로 Discount를 반환하는지 확인한다.")
        @Test
        void checkGetDiscount() {
            DiscountEvent discountEvent = new ChampagneGiveawayEvent(120_000);
            Discount discount = discountEvent.getDiscount();
            Discount expected = new Discount("증정 이벤트", 25_000);
            assertEquals(discount, expected);
        }

    }

    @DisplayName("getGiveaway 테스트")
    @Nested
    class getGiveaway {

        @DisplayName("정상적으로 Giveaway를 반환하는지 확인한다.")
        @Test
        void checkGetGiveaway() {
            GiveawayEvent giveawayEvent = new ChampagneGiveawayEvent(120_000);
            Giveaway giveaway = giveawayEvent.getGiveaway();
            Giveaway expected = new Giveaway("샴페인", 1);
            assertEquals(giveaway, expected);
        }

    }

}