package christmas.service;

import christmas.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private static OrderService orderService;

    @BeforeAll
    private static void setup() {
        orderService = new OrderService();
    }

    @DisplayName("createOrder 테스트")
    @Nested
    class createOrder {

        @DisplayName("대시가 1개가 아니면 오류를 반환한다.")
        @ParameterizedTest
        @ValueSource(strings = {"바비큐립1", "바비큐립--1", "바비큐-립-1"})
        void givenStringHasWrongDashCount(String orderString) {
            assertThatThrownBy(() -> orderService.createOrder(orderString))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }

        @DisplayName("메뉴가 존재하지 않으면 오류를 반환한다.")
        @Test
        void givenMenuStringIsNotExist() {
            assertThatThrownBy(() -> orderService.createOrder("이상한요리-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }

        @DisplayName("count 부분이 숫자가 아니면 오류를 반환한다.")
        @Test
        void givenCountIsNotNumber() {
            assertThatThrownBy(() -> orderService.createOrder("바비큐립-하나"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }

        @DisplayName("주어진 입력이 올바르면 정상적으로 생성한다.")
        @Test
        void givenStringIsProper() {
            assertDoesNotThrow(() -> orderService.createOrder("바비큐립-1"));
        }

    }

    @DisplayName("createOrders 테스트")
    @Nested
    class createOrders {

        @DisplayName("OrdersString을 쉼표로 분리하지 않으면 오류를 반환한다.")
        @Test
        void givenOrdersStringNotContainsCommas() {
            assertThatThrownBy(() -> orderService.createOrders("바비큐립-1:초코케이크-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }

    }

}