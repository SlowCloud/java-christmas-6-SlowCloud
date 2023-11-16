package christmas.fixture;

import christmas.domain.Order.Orders;

import java.util.List;

public enum OrdersFixture {

    APPETIZER(OrderFixture.APPETIZER),
    MAIN(OrderFixture.MAIN),
    DESSERT(OrderFixture.DESSERT),
    DRINK(OrderFixture.DRINK);

    private final OrderFixture orderFixture;

    OrdersFixture(OrderFixture orderFixture) {
        this.orderFixture = orderFixture;
    }

    public Orders getOrders() {
        return new Orders(List.of(orderFixture.getOrder()));
    }

}
