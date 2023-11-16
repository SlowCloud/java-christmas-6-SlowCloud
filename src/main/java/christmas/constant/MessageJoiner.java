package christmas.constant;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum MessageJoiner {

    EMPTY(
            List::isEmpty,
            (List<String> strings) -> "없음"
    ),
    EXIST(
            (List<String> strings) -> !strings.isEmpty(),
            (List<String> strings) -> String.join("\n", strings)
    );

    private final Function<List<String>, Boolean> verifier;
    private final Function<List<String>, String> joiner;

    MessageJoiner(Function<List<String>, Boolean> verifier, Function<List<String>, String> joiner) {
        this.verifier = verifier;
        this.joiner = joiner;
    }

    public static String join(List<String> strings) {
        return Arrays.stream(values())
                .filter(messageJoiner -> messageJoiner.verifier.apply(strings))
                .findFirst()
                .orElseThrow()
                .joiner.apply(strings);
    }

}
