package christmas.constant;

import java.util.Arrays;

public enum Menu {

    MUSHROOM_SOUP("양송이수프", Course.APPETIZER, 6_000),
    TAPAS("타파스", Course.APPETIZER, 5_500),
    CAESAR_SALAD("시저샐러드", Course.APPETIZER, 8_000),
    T_BONE_STEAK("티본스테이크", Course.MAIN, 55_000),
    BARBEQUE_RIBS("바비큐립", Course.MAIN, 54_000),
    SEAFOOD_PASTA("해산물파스타", Course.MAIN, 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", Course.MAIN, 25_000),
    CHOCO_CAKE("초코케이크", Course.DESSERT, 15_000),
    ICE_CREAM("아이스크림", Course.DESSERT, 5_000),
    ZERO_COKE("제로콜라", Course.DRINK, 3_000),
    RED_WINE("레드와인", Course.DRINK, 60_000),
    CHAMPAGNE("샴페인", Course.DRINK, 25_000);

    private final String name;
    private final Course course;
    private final int price;

    Menu(String name, Course course, int price) {
        this.name = name;
        this.course = course;
        this.price = price;
    }

    public static Menu getMenu(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    public String getMenuName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean is(Course course) {
        return this.course.equals(course);
    }

}
