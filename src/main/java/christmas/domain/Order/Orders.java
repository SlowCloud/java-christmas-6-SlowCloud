package christmas.domain.Order;

import christmas.constant.Course;

import java.util.List;

public class Orders {

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
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