package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Giveaway.Giveaway;
import christmas.domain.Order.Orders;
import christmas.fixture.OrderFixture;
import christmas.fixture.OrdersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

class ChampagneGiveawayEventTest {


    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("총 구매액이 12만을 넘지 않으면 null을 반환한다.")
        @Test
        void givenPriceIsLowerThanHundredTwentyThousand() {
            Orders cheapOrders = mock(Orders.class);
            given(cheapOrders.getTotalPrice()).willReturn(10);
            assertNull(ChampagneGiveawayEvent.createInstance(cheapOrders));
        }

        @DisplayName("총 구매액이 12만을 넘으면 않으면 null을 반환한다.")
        @Test
        void givenPriceIsEnough() {
            Orders expensiveOrders = mock(Orders.class);
            given(expensiveOrders.getTotalPrice()).willReturn(120_000);
            assertNotNull(ChampagneGiveawayEvent.createInstance(expensiveOrders));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("정상적으로 Discount를 반환하는지 확인한다.")
        @Test
        void checkGetDiscount() {
            Orders expensiveOrders = mock(Orders.class);
            given(expensiveOrders.getTotalPrice()).willReturn(120_000);
            DiscountEvent discountEvent = (DiscountEvent) ChampagneGiveawayEvent.createInstance(expensiveOrders);
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
            Orders expensiveOrders = mock(Orders.class);
            given(expensiveOrders.getTotalPrice()).willReturn(120_000);
            GiveawayEvent giveawayEvent = (GiveawayEvent) ChampagneGiveawayEvent.createInstance(expensiveOrders);
            Giveaway giveaway = giveawayEvent.getGiveaway();
            Giveaway expected = new Giveaway("샴페인", 1);
            assertEquals(giveaway, expected);
        }

    }

}