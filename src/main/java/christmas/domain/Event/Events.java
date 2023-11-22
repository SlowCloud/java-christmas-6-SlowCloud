package christmas.domain.Event;

import christmas.domain.Discount.Discounts;
import christmas.domain.Giveaway.Giveaways;

import java.util.List;
import java.util.function.Function;

public class Events {

    private final List<Event> events;

    public Events(List<Event> events) {
        this.events = events;
    }

    public Discounts getTotalDiscounts() {
        return new Discounts(getFilteredEvents(DiscountEvent.class)
                .stream()
                .map(DiscountEvent::getDiscount)
                .toList());
    }

    public Giveaways getGiveaways() {
        return new Giveaways(getFilteredEvents(GiveawayEvent.class)
                .stream()
                .map(GiveawayEvent::getGiveaway)
                .toList());
    }

    public Discounts getDiscountsExceptGiveaways() {
        return new Discounts(getFilteredEvents(DiscountEvent.class, event -> !(event instanceof GiveawayEvent))
                .stream()
                .map(DiscountEvent::getDiscount)
                .toList());
    }

    private <T extends Event> List<T> getFilteredEvents(Class<T> eventType) {
        return getFilteredEvents(eventType, eventType::isInstance);
    }

    private <T extends Event> List<T> getFilteredEvents(Class<T> eventType, Function<Event, Boolean> filter) {
        return events.stream()
                .filter(filter::apply)
                .map(eventType::cast)
                .toList();
    }

}
