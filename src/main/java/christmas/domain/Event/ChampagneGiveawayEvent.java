package christmas.domain.Event;

import christmas.constant.Menu;
import christmas.domain.Discount.Discount;
import christmas.domain.Giveaway.Giveaway;

public class ChampagneGiveawayEvent implements GiveawayEvent, DiscountEvent {

    public static final int GIVEAWAY_AVAILABLE_PRICE = 120_000;
    private final Menu champagne = Menu.CHAMPAGNE;
    private final int count = 1;

    public ChampagneGiveawayEvent(int price) {
        Event.validatePrice(price);
        validateAvailablePrice(price);
    }

    private void validateAvailablePrice(int price) {
        if (price < GIVEAWAY_AVAILABLE_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public static Event createInstance(int price) {
        try {
            return new ChampagneGiveawayEvent(price);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public Discount getDiscount() {
        return new Discount("증정 이벤트", champagne.getPrice());
    }

    @Override
    public Giveaway getGiveaway() {
        return new Giveaway(champagne.getMenuName(), count);
    }

}
