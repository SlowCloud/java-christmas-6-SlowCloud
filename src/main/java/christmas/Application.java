package christmas;

import christmas.controller.ChristmasController;
import christmas.service.OrderService;
import christmas.service.TodayService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        TodayService todayService = new TodayService();
        OrderService orderService = new OrderService();

        ChristmasController christmasController = new ChristmasController(
                inputView,
                outputView,
                orderService,
                todayService
        );

        christmasController.play();

    }
}
