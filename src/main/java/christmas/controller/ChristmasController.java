package christmas.controller;

import christmas.constant.Badge;
import christmas.domain.Discount.Discounts;
import christmas.domain.Event.Events;
import christmas.domain.Event.EventsBuilder;
import christmas.domain.Giveaway.Giveaways;
import christmas.domain.Order.Orders;
import christmas.domain.Today.Today;
import christmas.util.Looper;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class ChristmasController {

    private final InputView inputView;
    private final OutputView outputView;


    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

        outputView.printHeader();

        Today today = getToday();
        Orders orders = getOrders();
        Events events = getEvents(today, orders);

        outputView.printEventPreviewMessage();
        printEventBenefits(orders, events);

    }

    private Today getToday() {
        return tryCatchLoop(() -> Today.of(inputView.getToday()));
    }

    private Orders getOrders() {
        return tryCatchLoop(() -> Orders.of(inputView.getOrders()));
    }

    private <T> T tryCatchLoop(Supplier<T> supplier) {
        return Looper.tryCatchLoop(supplier, outputView::printIllegalArgumentException);
    }

    private Events getEvents(Today today, Orders orders) {
        return new EventsBuilder()
                .today(today)
                .orders(orders)
                .build();
    }

    private void printEventBenefits(Orders orders, Events events) {
        printOrderedMenus(orders);
        printTotalPriceBeforeDiscount(orders);
        printGiveaway(events);
        printDiscountMessage(events);
        printTotalDiscountedPrice(events);
        printTotalPriceAfterDiscount(orders, events);
        printBadge(events);
    }

    private void printOrderedMenus(Orders orders) {
        outputView.printOrderedMenus(orders.getOrderedMenusMessage());
    }

    private void printTotalPriceBeforeDiscount(Orders orders) {
        outputView.printTotalPriceBeforeDiscount(orders.getTotalPrice());
    }

    private void printGiveaway(Events events) {
        Giveaways giveaways = events.getGiveaways();
        outputView.printGiveaway(giveaways.getGiveawayMessage());
    }

    private void printDiscountMessage(Events events) {
        Discounts totalDiscounts = events.getTotalDiscounts();
        outputView.printDiscountsMessage(totalDiscounts.getDiscountsMessage());
    }

    private void printTotalDiscountedPrice(Events events) {
        Discounts totalDiscounts = events.getTotalDiscounts();
        outputView.printTotalDiscountedPrice(totalDiscounts.getTotalDiscountedPrice());
    }

    private void printTotalPriceAfterDiscount(Orders orders, Events events) {
        Discounts actualDiscounts = events.getDiscountsExceptGiveaways();
        outputView.printTotalPriceAfterDiscount(orders.getTotalPrice() + actualDiscounts.getTotalDiscountedPrice());
    }

    private void printBadge(Events events) {
        Discounts totalDiscounts = events.getTotalDiscounts();
        Badge badge = Badge.findBadge(totalDiscounts.getTotalDiscountedPrice());
        outputView.printBadge(badge.getBadgeName());
    }

}
