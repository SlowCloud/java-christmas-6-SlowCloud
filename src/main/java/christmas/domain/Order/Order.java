package christmas.domain.Order;

import christmas.constant.Course;
import christmas.constant.ExceptionMessage;
import christmas.constant.Menu;

public class Order {

    private final Menu menu;
    private final int count;

    public Order(String name, int count) {
        validateMenu(name);
        validateCount(count);
        this.menu = Menu.getMenu(name);
        this.count = count;
    }

    private void validateMenu(String name) {
        if (Menu.getMenu(name) == null) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

    private void validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

    public String getMessage() {
        return String.format(menu.getMenuName() + " %d개", count);
    }

    public int getPrice() {
        return menu.getPrice() * count;
    }

    public int getCount() {
        return count;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean is(Course course) {
        return menu.is(course);
    }

}
