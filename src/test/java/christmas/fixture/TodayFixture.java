package christmas.fixture;

import christmas.domain.Today;

public enum TodayFixture {

    WEEKEND(2),
    WEEKDAY(4),
    SUNDAY(3),
    CHRISTMAS(25),
    BEFORE_CHRISTMAS(1),
    AFTER_CHRISTMAS(26),
    NOT_SPECIAL(3),
    FIRST_DAY(1);

    private final int day;

    TodayFixture(int day) {
        this.day = day;
    }

    public Today getToday() {
        return new Today(day);
    }

}
