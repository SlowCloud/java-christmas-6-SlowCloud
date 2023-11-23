package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.fixture.OrderFixture;
import christmas.fixture.OrdersFixture;
import christmas.fixture.TodayFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SpecialEventTest {

    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("크리스마스 또는 일요일이 아니면 null을 반환한다.")
        @Test
        void givenTodayIsNotSpecial() {
            assertNull(SpecialEvent.createInstance(
                    TodayFixture.WEEKEND.getToday(),
                    OrdersFixture.MAIN.getOrders()
            ));
        }

        @DisplayName("크리스마스 또는 일요일이라면 정상적으로 생성한다.")
        @ParameterizedTest
        @MethodSource("provideToday")
        void givenTodayIsProper(TodayFixture todayFixture) {
            assertNotNull(SpecialEvent.createInstance(
                    todayFixture.getToday(),
                    OrdersFixture.MAIN.getOrders()
            ));
        }

        private static Stream<Arguments> provideToday() {
            return Stream.of(
                    Arguments.of(TodayFixture.SUNDAY),
                    Arguments.of(TodayFixture.CHRISTMAS)
            );
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("특별 할인이 제대로 적용되는지 확인한다.")
        @Test
        void checkGetDiscount() {

            DiscountEvent discountEvent = (DiscountEvent) SpecialEvent.createInstance(
                    TodayFixture.CHRISTMAS.getToday(),
                    OrdersFixture.MAIN.getOrders()
            );

            Discount discount = discountEvent.getDiscount();
            Discount expected = new Discount("특별 할인", 1000);

            assertEquals(discount, expected);

        }

    }

}