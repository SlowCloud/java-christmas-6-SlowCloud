package christmas.domain.Event;

import christmas.constant.Calender;
import christmas.constant.Course;
import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.domain.Today;

public class WeekdayEvent implements DiscountEvent {

    private static final String EVENT_NAME = "평일 할인";

    private final int mainDishCount;

    public WeekdayEvent(Today today, Orders orders) {
        Event.validatePrice(orders.getTotalPrice());
        validateToday(today);
        validateMain(orders);
        this.mainDishCount = orders.getCourseCount(Course.MAIN);
    }

    private void validateToday(Today today) {
        if (!today.is(Calender.WEEKDAY)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMain(Orders orders) {
        if (orders.getCourseCount(Course.MAIN) == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static Event createInstance(Today today, Orders orders) {
        try {
            return new WeekdayEvent(today, orders);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public Discount getDiscount() {
        return new Discount(EVENT_NAME, mainDishCount * 2023);
    }

}
