package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Discount.Discounts;
import christmas.domain.Giveaway.Giveaways;

import java.util.List;

public class Events {

    private final List<Event> events;

    public Events(List<Event> events) {
        this.events = events;
    }

    public Discounts getTotalDiscounts() {
        return new Discounts(events.stream()
                .filter(event -> event instanceof DiscountEvent)
                .map(event -> (DiscountEvent) event)
                .map(DiscountEvent::getDiscount)
                .toList());
    }

    public Giveaways getGiveaways() {
        return new Giveaways(events.stream()
                .filter(event -> event instanceof GiveawayEvent)
                .map(event -> (GiveawayEvent) event)
                .map(GiveawayEvent::getGiveaway)
                .toList());
    }

    public Discounts getDiscountsExceptGiveaways() {
        return new Discounts(events.stream()
                .filter(event -> !(event instanceof GiveawayEvent))
                .map(event -> (DiscountEvent) event)
                .map(DiscountEvent::getDiscount)
                .toList());
    }

}
