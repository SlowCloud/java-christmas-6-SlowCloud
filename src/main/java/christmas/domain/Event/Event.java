package christmas.domain.Event;

public interface Event {

    int EVENT_AVAILABLE_PRICE = 10_000;

    public static void validatePrice(int price) {
        if (price < EVENT_AVAILABLE_PRICE) {
            throw new IllegalArgumentException();
        }
    }

}
