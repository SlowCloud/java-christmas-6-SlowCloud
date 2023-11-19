package christmas.domain;

import christmas.constant.Calender;
import christmas.constant.ExceptionMessage;

import java.time.DateTimeException;
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

    public boolean is(Calender calender) {
        return calender.verify(localDate.getDayOfMonth());
    }

    public int getToday() {
        return localDate.getDayOfMonth();
    }

}
