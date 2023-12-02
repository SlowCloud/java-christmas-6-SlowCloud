package christmas.domain.Event;

import christmas.domain.Order.Orders;
import christmas.domain.Today.Today;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventsBuilder {

    private Today today;
    private Orders orders;

    public EventsBuilder() {
    }

    public EventsBuilder today(Today today) {
        this.today = today;
        return this;
    }

    public EventsBuilder orders(Orders orders) {
        this.orders = orders;
        return this;
    }

    public Events build() {
        return new Events(buildEvents());
    }

    private List<Event> buildEvents() {
        List<Event> events = new ArrayList<>();
        events.add(ChristmasDDayEvent.createInstance(today, orders));
        events.add(WeekdayEvent.createInstance(today, orders));
        events.add(WeekendEvent.createInstance(today, orders));
        events.add(SpecialEvent.createInstance(today, orders));
        events.add(ChampagneGiveawayEvent.createInstance(orders));
        return events.stream()
                .filter(Objects::nonNull)
                .toList();
    }

}
