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
        return new Discounts(getEventStream(DiscountEvent.class)
                .map(DiscountEvent::getDiscount)
                .toList());
    }

    public Giveaways getGiveaways() {
        return new Giveaways(getEventStream(GiveawayEvent.class)
                .map(GiveawayEvent::getGiveaway)
                .toList());
    }

    public Discounts getDiscountsExceptGiveaways() {
        return new Discounts(getEventStream(DiscountEvent.class, event -> !(event instanceof GiveawayEvent))
                .map(DiscountEvent::getDiscount)
                .toList());
    }

    private <T extends Event> Stream<T> getEventStream(Class<T> eventType) {
        return getEventStream(eventType, eventType::isInstance);
    }

    private <T extends Event> Stream<T> getEventStream(Class<T> eventType, Function<Event, Boolean> filter) {
        return events.stream()
                .filter(filter::apply)
                .map(eventType::cast);
    }

}
