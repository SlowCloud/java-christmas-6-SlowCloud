package christmas.domain;

public class Discount {

    private final String message;

    public Discount(String discountMessage, int discount) {
        this.message = String.format(discountMessage + ": -%,d원", discount);
    }

    public String getMessage() {
        return message;
    }

}
