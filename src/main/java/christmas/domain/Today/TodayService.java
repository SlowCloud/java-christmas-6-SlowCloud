package christmas.domain.Today;

import christmas.constant.ExceptionMessage;

class TodayService {

    public Today createToday(String today) {
        validateNumber(today);
        return new Today(Integer.parseInt(today));
    }

    private void validateNumber(String today) {
        try {
            Integer.parseInt(today);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TODAY_MESSAGE);
        }
    }

}
