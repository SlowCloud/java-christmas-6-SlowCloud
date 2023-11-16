package christmas.domain.Giveaway;

import christmas.constant.MessageJoiner;

import java.util.List;

public class Giveaways {

    private final List<Giveaway> giveaways;

    public Giveaways(List<Giveaway> giveaways) {
        this.giveaways = giveaways;
    }

    public String getGiveawayMessage() {
        List<String> messages = giveaways.stream()
                .map(Giveaway::getMessage)
                .toList();
        return MessageJoiner.join(messages);
    }

}
