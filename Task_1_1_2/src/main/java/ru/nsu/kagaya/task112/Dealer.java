package ru.nsu.kagaya.task112;

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