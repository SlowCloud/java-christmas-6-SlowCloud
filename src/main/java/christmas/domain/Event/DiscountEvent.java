package christmas.domain.Event;

import christmas.domain.Discount.Discount;

public interface DiscountEvent extends Event {

    Discount getDiscount();

}
