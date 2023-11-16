package christmas.domain.Event;

import christmas.constant.Calender;
import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.domain.Today;

public class SpecialEvent implements DiscountEvent {

    private static final String EVENT_NAME = "특별 할인";

    public SpecialEvent(Today today, Orders orders) {
        Event.validatePrice(orders.getTotalPrice());
        validateToday(today);
    }

    private void validateToday(Today today) {
        if (!(today.is(Calender.CHRISTMAS) || today.is(Calender.SUNDAY))) {
            throw new IllegalArgumentException();
        }
    }

    public static Event createInstance(Today today, Orders orders) {
        try {
            return new SpecialEvent(today, orders);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public Discount getDiscount() {
        return new Discount(EVENT_NAME, 1000);
    }

}
