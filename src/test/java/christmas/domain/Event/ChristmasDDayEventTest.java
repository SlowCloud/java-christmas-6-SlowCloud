package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Today.Today;
import christmas.fixture.OrdersFixture;
import christmas.fixture.TodayFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDDayEventTest {

    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("크리스마스 이전이 아니라면 null을 반환한다.")
        @Test
        void givenTodayIsAfterChristmas() {
            assertNull(ChristmasDDayEvent.createInstance(
                    TodayFixture.AFTER_CHRISTMAS.getToday(),
                    OrdersFixture.MAIN.getOrders()
            ));
        }

        @DisplayName("크리스마스 이전이라면 정상적으로 생성한다.")
        void givenTdoayIsChristmas() {
            assertNotNull(ChristmasDDayEvent.createInstance(
                    TodayFixture.BEFORE_CHRISTMAS.getToday(),
                    OrdersFixture.MAIN.getOrders()
            ));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("크리스마스 디데이 할인이 제대로 적용되는지 확인한다.")
        @ParameterizedTest
        @CsvSource(value = {"1,1000", "2,1100"})
        void checkGetDiscount(int day, int expectedDiscount) {

            DiscountEvent discountEvent = (DiscountEvent) ChristmasDDayEvent.createInstance(
                    new Today(day),
                    OrdersFixture.MAIN.getOrders()
            );

            Discount discount = discountEvent.getDiscount();
            Discount expected = new Discount("크리스마스 디데이 할인", expectedDiscount);

            assertEquals(discount, expected);

        }

    }

}