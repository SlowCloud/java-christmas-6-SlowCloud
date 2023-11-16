package christmas.domain.Discount;

import christmas.constant.MessageJoiner;

import java.util.List;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public String getDiscountsMessage() {
        List<String> messages = discounts.stream()
                .map(Discount::getMessage)
                .toList();
        return MessageJoiner.join(messages);
    }

    public int getTotalDiscountedPrice() {
        return discounts.stream()
                .mapToInt(Discount::getDiscountedPrice)
                .sum();
    }

}
