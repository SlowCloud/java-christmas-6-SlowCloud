package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.fixture.OrdersFixture;
import christmas.fixture.TodayFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekendEventTest {

    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("주말이 아니면 null을 반환한다.")
        @Test
        void givenTodayIsNotWeekday() {
            assertNull(WeekendEvent.createInstance(
                    TodayFixture.WEEKDAY.getToday(),
                    OrdersFixture.DESSERT.getOrders()
            ));
        }

        @DisplayName("주문에 디저트가 없으면 null을 반환한다.")
        @Test
        void givenOrdersNotContainMain() {
            assertNull(WeekendEvent.createInstance(
                    TodayFixture.WEEKEND.getToday(),
                    OrdersFixture.MAIN.getOrders()
            ));
        }

        @DisplayName("주말이고, 주문에 디저트가 있으면 정상적으로 생성한다.")
        @Test
        void givenTodayIsWeekendAndGivenOrdersContainDessert() {
            assertNotNull(WeekendEvent.createInstance(
                    TodayFixture.WEEKEND.getToday(),
                    OrdersFixture.DESSERT.getOrders()
            ));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("평일 할인이 제대로 적용되는지 확인한다.")
        @Test
        void checkGetDiscount() {

            DiscountEvent discountEvent = (DiscountEvent) WeekendEvent.createInstance(
                    TodayFixture.WEEKEND.getToday(),
                    OrdersFixture.DESSERT.getOrders()
            );

            Discount discount = discountEvent.getDiscount();
            Discount expected = new Discount("주말 할인", 2023);

            assertEquals(discount, expected);

        }

    }

}