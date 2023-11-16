package christmas.domain.Order;

import christmas.constant.Course;
import christmas.constant.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Order 테스트")
class OrderTest {

    @DisplayName("생성자 테스트")
    @Nested
    class constructor {

        @DisplayName("메뉴가 존재하지 않으면 오류를 던진다.")
        @Test
        void givenMenuIsNotExist() {
            assertThatThrownBy(() -> new Order("A!", 1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("개수가 0 이하이면 오류를 던진다.")
        @ParameterizedTest
        @ValueSource(ints = {0, -1, -2})
        void givenCountIsLessThanOrEqualsToZero(int count) {
            assertThatThrownBy(() -> new Order("양송이수프", count))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @DisplayName("getMessage 테스트")
    @Nested
    class getMessage {

        @DisplayName("출력 메시지를 확인한다.")
        @Test
        void checkGetMessage() {
            Order order = new Order("양송이수프", 1);
            assertEquals(order.getMessage(), "양송이수프 1개");
        }

    }

    @DisplayName("getPrice 테스트")
    @Nested
    class getPrice {

        @DisplayName("가격을 확인한다.")
        @Test
        void checkGetPrice() {
            Order order = new Order("양송이수프", 1);
            assertEquals(order.getPrice(), Menu.MUSHROOM_SOUP.getPrice());
        }

    }

    @DisplayName("getMenu 테스트")
    @Nested
    class getMenu {

        @DisplayName("메뉴를 확인한다.")
        @Test
        void checkGetMenu() {
            Order order = new Order("양송이수프", 1);
            assertEquals(order.getMenu(), Menu.MUSHROOM_SOUP);
        }

    }

    @DisplayName("is 테스트")
    @Nested
    class is {

        @DisplayName("코스에 해당하면 참을 반환한다.")
        @Test
        void givenCourseIsSame() {
            Order order = new Order("양송이수프", 1);
            assertTrue(order.is(Course.APPETIZER));
        }

        @DisplayName("코스에 해당하지 않으면 거짓을 반환한다.")
        @Test
        void givenCourseIsDifferent() {
            Order order = new Order("양송이수프", 1);
            assertFalse(order.is(Course.MAIN));
        }

    }

}