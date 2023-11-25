package christmas.domain.Order;

import christmas.constant.Course;
import christmas.fixture.OrderFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdersTest {

    @DisplayName("생성자 테스트")
    @Nested
    class constructor {

        @DisplayName("메뉴가 겹치면 오류를 반환한다.")
        @Test
        void GivenOrdersAreDuplicated() {
            Assertions.assertThatThrownBy(
                    () -> new Orders(List.of(
                            OrderFixture.APPETIZER.getOrder(),
                            OrderFixture.APPETIZER.getOrder())
                    )
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("주문 메뉴가 음료뿐이면 오류를 반환한다.")
        @Test
        void givenOrdersAreOnlyDrink() {
            Assertions.assertThatThrownBy(
                    () -> new Orders(List.of(OrderFixture.DRINK.getOrder()))
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("총 주문의 양이 20개를 넘으면 오류를 반환한다.")
        @Test
        void givenOrdersAreOver20() {
            Assertions.assertThatThrownBy(
                    () -> new Orders(List.of(OrderFixture.COUNT_OVER_20.getOrder()))
            ).isInstanceOf(IllegalArgumentException.class);
        }

    }

    @DisplayName("getOrderedMenusMessage 테스트")
    @Nested
    class getOrderedMenusMessage {

        @DisplayName("메시지를 정상적으로 출력하는지 확인한다.")
        @Test
        void checkGetOrderedMenusMessage() {
            Orders orders = new Orders(List.of(OrderFixture.APPETIZER.getOrder()));
            assertEquals(orders.getOrderedMenusMessage(), "양송이수프 1개");
        }

    }

    @DisplayName("getCourseCount 테스트")
    @Nested
    class getCourseCount {

        @DisplayName("코스에 포함되는 주문의 개수를 계산한다.")
        @Test
        void checkGetCourseCount() {
            Orders orders = new Orders(List.of(OrderFixture.APPETIZER.getOrder()));
            assertEquals(orders.getCourseCount(Course.APPETIZER), 1);
        }

    }

}