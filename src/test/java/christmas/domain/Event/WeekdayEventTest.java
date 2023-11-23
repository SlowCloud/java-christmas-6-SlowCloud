package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Order.Order;
import christmas.domain.Order.Orders;
import christmas.fixture.OrderFixture;
import christmas.fixture.OrdersFixture;
import christmas.fixture.TodayFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeekdayEventTest {

    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("평일이 아니면 null을 반환한다.")
        @Test
        void givenTodayIsNotWeekday() {
            assertNull(WeekdayEvent.createInstance(
                    TodayFixture.WEEKEND.getToday(),
                    OrdersFixture.MAIN.getOrders()
            ));
        }

        @DisplayName("주문에 메인 메뉴가 없으면 null을 반환한다.")
        @Test
        void givenOrdersNotContainMain() {
            assertNull(WeekdayEvent.createInstance(
                    TodayFixture.WEEKDAY.getToday(),
                    OrdersFixture.DESSERT.getOrders()
            ));
        }

        @DisplayName("평일이고, 주문에 메인 메뉴가 있으면 정상적으로 생성한다.")
        @Test
        void givenTodayIsWeekdayAndGivenOrdersContainMain() {
            assertNotNull(WeekdayEvent.createInstance(
                    TodayFixture.WEEKDAY.getToday(),
                    OrdersFixture.MAIN.getOrders()
            ));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("평일 할인이 제대로 적용되는지 확인한다.")
        @Test
        void checkGetDiscount() {

            DiscountEvent discountEvent = (DiscountEvent) WeekdayEvent.createInstance(
                    TodayFixture.WEEKDAY.getToday(),
                    new Orders(List.of(OrderFixture.MAIN.getOrder()))
            );

            Discount discount = discountEvent.getDiscount();
            Discount expected = new Discount("평일 할인", 2023);

            assertEquals(discount, expected);

        }

    }

}