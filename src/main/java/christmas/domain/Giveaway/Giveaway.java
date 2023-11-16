package christmas.domain.Giveaway;

import java.util.Objects;

public class Giveaway {

    private final String message;

    public Giveaway(String menuName, int count) {
        this.message = String.format("%s %d개", menuName, count);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giveaway giveaway = (Giveaway) o;
        return Objects.equals(message, giveaway.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

}
