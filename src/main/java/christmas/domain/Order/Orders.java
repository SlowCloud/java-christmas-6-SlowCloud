package christmas.domain.Order;

import christmas.constant.Course;
import christmas.constant.ExceptionMessage;

import java.util.List;

public class Orders {

    public static final int ORDER_COUNT_TOP_LIMIT = 20;
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateDuplication(orders);
        validateDrinkOnly(orders);
        validateCount(orders);
        this.orders = orders;
    }

    private void validateDuplication(List<Order> orders) {
        int menuCount = (int) orders.stream()
                .map(Order::getMenu)
                .distinct()
                .count();
        if (orders.size() != menuCount) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

    private void validateDrinkOnly(List<Order> orders) {
        int drinkCount = (int) orders.stream()
                .filter(order -> order.is(Course.DRINK))
                .count();
        if (orders.size() == drinkCount) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

    private void validateCount(List<Order> orders) {
        int count = orders.stream()
                .mapToInt(Order::getCount)
                .sum();
        if (count > ORDER_COUNT_TOP_LIMIT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

    public String getOrderedMenusMessage() {
        return String.join("\n", orders.stream()
                .map(Order::getMessage)
                .toList());
    }

    public int getTotalPrice() {
        return orders.stream()
                .mapToInt(Order::getPrice)
                .sum();
    }

    public int getCourseCount(Course course) {
        return (int) orders.stream()
                .filter(order -> order.is(course))
                .count();
    }

}
