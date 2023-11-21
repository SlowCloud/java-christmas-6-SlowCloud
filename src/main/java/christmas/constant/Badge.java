package christmas.constant;

import java.util.Arrays;

public enum Badge {


    NOTHING("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String badgeName;
    private final int availablePrice;

    Badge(String badgeName, int availablePrice) {
        this.badgeName = badgeName;
        this.availablePrice = availablePrice;
    }

    public static Badge findBadge(int discounted) {
        return Arrays.stream(values())
                .sorted((l, r) -> r.availablePrice - l.availablePrice)
                .filter(badge -> isAvailableBadge(badge, discounted))
                .findFirst()
                .orElseThrow();
    }

    private static boolean isAvailableBadge(Badge badge, int discounted) {
        return -badge.availablePrice >= discounted;
    }

    public String getBadgeName() {
        return badgeName;
    }

}
