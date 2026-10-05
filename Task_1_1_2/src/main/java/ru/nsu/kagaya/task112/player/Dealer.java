package ru.nsu.kagaya.task112.player;

import ru.nsu.kagaya.task112.game.Rules;

/**
 * Дилер.
 */
public class Dealer extends Someone {
    public Dealer() {
        super("Dealer");
    }

    /**
     * Дилер обязан открывать карты, пока сумма меньше 17.
     *
     * @return нужно ли брать карту
     */
    public boolean shouldTakeCard() {
        return getHand().getSum() < Rules.DEALER_STAND;
    }
}