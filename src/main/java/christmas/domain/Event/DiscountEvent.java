package christmas.domain.Event;

import christmas.domain.Discount.Discount;

interface DiscountEvent extends Event {

    Discount getDiscount();

}
