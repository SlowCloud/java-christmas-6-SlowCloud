package christmas.fixture;

import christmas.domain.Discount.Discount;

public enum DiscountFixture {

    BASE("메시지", 10_000, "메시지: -10,000원");

    private final String discountName;
    private final int discountPrice;
    private final String discountMessage;

    DiscountFixture(String discountName, int discountPrice, String discountMessage) {
        this.discountName = discountName;
        this.discountPrice = discountPrice;
        this.discountMessage = discountMessage;
    }

    public int getDiscountPrice() {
        return -discountPrice;
    }

    public String getDiscountName() {
        return discountName;
    }

    public String getDiscountMessage() {
        return discountMessage;
    }

    public Discount getDiscount() {
        return new Discount(discountName, discountPrice);
    }

}
