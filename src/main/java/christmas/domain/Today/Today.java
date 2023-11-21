package christmas.domain.Today;

import christmas.constant.ExceptionMessage;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Today {

    private final LocalDate localDate;

    public Today(int today) {
        validateTodayRange(today);
        localDate = LocalDate.of(2023, 12, today);
    }

    private void validateTodayRange(int today) {
        try {
            LocalDate.of(2023, 12, today);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TODAY_MESSAGE);
        }
    }

    public int getToday() {
        return localDate.getDayOfMonth();
    }

    public boolean isChristmas() {
        return localDate.getDayOfMonth() == 25;
    }

    public boolean isBeforeChristmas() {
        return localDate.getDayOfMonth() <= 25;
    }

    public boolean isSpecial() {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.SUNDAY) || isChristmas();
    }

    public boolean isWeekend() {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

}
