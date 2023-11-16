package christmas.constant;

import java.util.function.Function;

public enum Calender {

    BEFORE_CHRISTMAS(day -> day <= Constants.CHRISTMAS_DAY),
    CHRISTMAS(day -> day == Constants.CHRISTMAS_DAY),
    WEEKDAY(day -> !isDayOfWeek(day, Constants.FRIDAY) && !isDayOfWeek(day, Constants.SATURDAY)),
    WEEKEND(day -> isDayOfWeek(day, Constants.FRIDAY) || isDayOfWeek(day, Constants.SATURDAY)),
    SUNDAY(day -> isDayOfWeek(day, Constants.SUNDAY));

    private static boolean isDayOfWeek(Integer day, int dayOfWeek) {
        return day % Constants.WEEK_LENGTH == dayOfWeek;
    }

    private final Function<Integer, Boolean> verifier;

    Calender(Function<Integer, Boolean> verifier) {
        this.verifier = verifier;
    }

    public boolean verify(int day) {
        return verifier.apply(day);
    }

    private static class Constants {
        public static final int CHRISTMAS_DAY = 25;
        public static final int FRIDAY = 1;
        public static final int SATURDAY = 2;
        public static final int SUNDAY = 3;
        public static final int WEEK_LENGTH = 7;
    }

}
