package christmas.domain.Event;

import christmas.domain.Giveaway.Giveaway;

interface GiveawayEvent extends Event {

    Giveaway getGiveaway();

}
