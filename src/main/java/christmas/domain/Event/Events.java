package christmas.domain.Event;

import christmas.domain.Discount.Discounts;
import christmas.domain.Giveaway.Giveaways;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Events {

    private final List<Event> events;

    public Events(List<Event> events) {
        this.events = events;
    }

    public Discounts getTotalDiscounts() {
        return new Discounts(EventFilter.getDiscountEvents(events).stream()
                .map(DiscountEvent::getDiscount)
                .toList());
    }

    public Giveaways getGiveaways() {
        return new Giveaways(EventFilter.getGiveawayEvents(events).stream()
                .map(GiveawayEvent::getGiveaway)
                .toList());
    }

    public Discounts getDiscountsExceptGiveaways() {
        return new Discounts(EventFilter.getDiscountEventsNotGiveawayEvent(events).stream()
                .map(DiscountEvent::getDiscount)
                .toList());
    }

}
