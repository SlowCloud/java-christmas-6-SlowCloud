package christmas.domain.Event;

import java.util.List;

class EventFilter {

    private EventFilter() {
    }

    public static List<DiscountEvent> getDiscountEvents(List<Event> events) {
        return getFilteredEvents(events, DiscountEvent.class);
    }

    public static List<GiveawayEvent> getGiveawayEvents(List<Event> events) {
        return getFilteredEvents(events, GiveawayEvent.class);
    }

    private static <T extends Event> List<T> getFilteredEvents(List<Event> events, Class<T> eventType) {
        return events.stream()
                .filter(eventType::isInstance)
                .map(eventType::cast)
                .toList();
    }

    public static List<DiscountEvent> getDiscountEventsNotGiveawayEvent(List<Event> events) {
        return events.stream()
                .filter(event -> !(event instanceof GiveawayEvent))
                .map(event -> (DiscountEvent) event)
                .toList();
    }

}
