package christmas.constant;

import java.util.Arrays;
import java.util.function.Function;

public enum Badge {

    NOTHING("없음", discounted -> discounted > Constants.STAR_AVAILABLE),
    STAR("별", discounted -> discounted > Constants.TREE_AVAILABLE),
    TREE("트리", discounted -> discounted > Constants.SANTA_AVAILABLE),
    SANTA("산타", discounted -> discounted <= Constants.SANTA_AVAILABLE);

    private final String badgeName;
    private final Function<Integer, Boolean> validator;

    Badge(String badgeName, Function<Integer, Boolean> validator) {
        this.badgeName = badgeName;
        this.validator = validator;
    }

    public static Badge findBadge(int discounted) {
        return Arrays.stream(values())
                .filter(badge -> badge.validator.apply(discounted))
                .findFirst()
                .orElseThrow();
    }

    public String getBadgeName() {
        return badgeName;
    }

    private static class Constants {
        public static final int STAR_AVAILABLE = -5000;
        public static final int TREE_AVAILABLE = -10000;
        public static final int SANTA_AVAILABLE = -20000;
    }
}
