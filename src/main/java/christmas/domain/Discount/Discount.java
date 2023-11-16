package christmas.domain.Discount;

import java.util.Objects;

public class Discount {

    private final String message;
    private final int discountedPrice;

    public Discount(String discountMessage, int discountedPrice) {
        this.discountedPrice = -discountedPrice;
        this.message = String.format(discountMessage + ": %,d원", -discountedPrice);
    }

    public String getMessage() {
        return message;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return discountedPrice == discount1.discountedPrice && Objects.equals(message, discount1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, discountedPrice);
    }

}
