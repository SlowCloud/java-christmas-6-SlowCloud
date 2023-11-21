package christmas.domain.Order;

import christmas.constant.ExceptionMessage;
import christmas.domain.Order.Order;
import christmas.domain.Order.Orders;

import java.util.Arrays;
import java.util.List;

public class OrderService {

    private static final String ORDERS_STRING_DELIMITER = ",";
    private static final String DASH_STRING = "-";
    private static final char DASH_CHAR = '-';
    private static final int DASH_COUNT = 1;

    public Orders createOrders(String ordersString) {
        List<Order> orders = Arrays.stream(ordersString.split(ORDERS_STRING_DELIMITER))
                .map(this::createOrder)
                .toList();
        return new Orders(orders);
    }

    public Order createOrder(String orderString) {
        validateDash(orderString);
        String[] splitedString = orderString.split(DASH_STRING);
        return createOrder(splitedString[0].trim(), splitedString[1].trim());
    }

    private void validateDash(String orderString) {
        if (getDashCount(orderString) != DASH_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

    private long getDashCount(String orderString) {
        return orderString.chars()
                .filter(value -> value == DASH_CHAR)
                .count();
    }

    private Order createOrder(String menu, String count) {
        validateNumber(count);
        return new Order(menu, Integer.parseInt(count));
    }

    private void validateNumber(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

}
