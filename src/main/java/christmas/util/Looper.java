package christmas.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Looper {

    private Looper() {
    }

    public static <T> T tryCatchLoop(Supplier<T> supplier, Consumer<IllegalArgumentException> exceptionConsumer) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                exceptionConsumer.accept(e);
            }
        }
    }

}
