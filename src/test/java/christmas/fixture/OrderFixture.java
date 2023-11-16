package christmas.fixture;

import christmas.domain.Order.Order;

public enum OrderFixture {

    APPETIZER("양송이수프", 1),
    DRINK("샴페인", 1),
    MAIN("바비큐립", 1),
    DESSERT("초코케이크", 1),
    COUNT_OVER_20("양송이수프", 50);

    private final String menuName;
    private final int count;

    OrderFixture(String menuName, int count) {
        this.menuName = menuName;
        this.count = count;
    }

    public Order getOrder() {
        return new Order(menuName, count);
    }

}
