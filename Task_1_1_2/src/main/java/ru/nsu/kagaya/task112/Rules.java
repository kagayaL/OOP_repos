package ru.nsu.kagaya.task112;

/**
 * Правила блэкджека.
 */
public final class Rules {
    public static final int BLACKJACK = 21;
    public static final int DEALER_STAND = 17;
    public static final int MIN_DECKS = 1;
    public static final int MAX_DECKS = 8;

    private Rules() {
    }

    /**
     * Определяет исход раунда по суммам очков.
     *
     * @param playerSum сумма очков игрока
     * @param dealerSum сумма очков дилера
     * @return исход раунда
     */
    public static RoundResult determineResult(int playerSum, int dealerSum) {
        if (playerSum > BLACKJACK) {
            return RoundResult.DEALER_WIN;
        }
        if (dealerSum > BLACKJACK) {
            return RoundResult.PLAYER_WIN;
        }
        if (playerSum > dealerSum) {
            return RoundResult.PLAYER_WIN;
        }
        if (playerSum < dealerSum) {
            return RoundResult.DEALER_WIN;
        }
        return RoundResult.DRAW;
    }
}