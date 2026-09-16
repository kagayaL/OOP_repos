package ru.nsu.kagaya.task112;

import static ru.nsu.kagaya.task112.Card.Rank.ACE;

/**
 * Класс, реализующий руку с картами.
 */
public class Hand {
    private static final int BLACKJACK = 21;
    private static final int ACE_DIFFERENCE = 10;
    private static final int HAND_CAP = 100;

    Card[] cards = new Card[HAND_CAP];
    int cardCount = 0;
    int currSum = 0;
    int highAceCnt = 0;
    int lowAceCnt = 0;

    /**
     * Добавляет в руку новую карту с перерасчетом очков.
     *
     * @param card новая карта
     */
    public void getNewCard(Card card) {
        cards[cardCount++] = card;
        if (card.rank == ACE) {
            highAceCnt++;
        }
        currSum += card.rank.getValue();
        if (currSum > BLACKJACK && highAceCnt > 0) {
            currSum -= ACE_DIFFERENCE;
            highAceCnt--;
            lowAceCnt++;
        }
    }

    /**
     * Функция для получения очков на руке.
     *
     * @return сумма очков
     */
    public int getSum() {
        return currSum;
    }
}