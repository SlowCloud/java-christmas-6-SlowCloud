package christmas.domain.Event;

import christmas.constant.Course;
import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.domain.Today;

public class WeekendEvent implements DiscountEvent {

    private static final String EVENT_NAME = "주말 할인";

    private final int dessertCount;

    public WeekendEvent(Today today, Orders orders) {
        Event.validatePrice(orders.getTotalPrice());
        validateToday(today);
        validateDessert(orders);
        this.dessertCount = orders.getCourseCount(Course.DESSERT);
    }

    private void validateToday(Today today) {
        if (!today.isWeekend()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDessert(Orders orders) {
        if (orders.getCourseCount(Course.DESSERT) == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static Event createInstance(Today today, Orders orders) {
        try {
            return new WeekendEvent(today, orders);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public Discount getDiscount() {
        return new Discount(EVENT_NAME, dessertCount * 2023);
    }

}
