package ru.nsu.kagaya.task112;

import static ru.nsu.kagaya.task112.Rank.ACE;

/**
 * Класс, реализующий руку с картами.
 */
public class Hand {
    private static final int BLACKJACK = 21;
    private static final int ACE_DIFFERENCE = 10;
    private static final int HAND_CAP = 100;

    private final Card[] cards = new Card[HAND_CAP];
    private int cardCount = 0;
    private int currSum = 0;
    private int highAceCnt = 0;
    private int lowAceCnt = 0;

    /**
     * Добавляет в руку новую карту с перерасчетом очков.
     *
     * @param card новая карта
     * @return true, если добавленный туз считается за 1 очко
     */
    public boolean addCard(Card card) {
        boolean isAceLow = false;
        cards[cardCount++] = card;
        if (card.getRank() == ACE) {
            highAceCnt++;
        }
        currSum += card.getRank().getValue();
        if (currSum > BLACKJACK && highAceCnt > 0) {
            currSum -= ACE_DIFFERENCE;
            highAceCnt--;
            lowAceCnt++;
            isAceLow = card.getRank() == ACE;
        }
        return isAceLow;
    }

    /**
     * Функция для получения очков на руке.
     *
     * @return сумма очков
     */
    public int getSum() {
        return currSum;
    }

    /**
     * Количество карт в руке.
     *
     * @return количество карт
     */
    public int getCardCount() {
        return cardCount;
    }

    /**
     * Карта по индексу.
     *
     * @param index индекс карты
     * @return карта
     */
    public Card getCard(int index) {
        return cards[index];
    }

    /**
     * Количество тузов, считающихся за 1 очко.
     *
     * @return количество "низких" тузов
     */
    public int getLowAceCnt() {
        return lowAceCnt;
    }

    /**
     * Перебор (сумма больше 21).
     *
     * @return true, если сумма превысила 21
     */
    public boolean isBust() {
        return currSum > BLACKJACK;
    }

    /**
     * Блэкджек — 21 из двух карт.
     *
     * @return true, если 21 из двух карт
     */
    public boolean isBlackjack() {
        return cardCount == 2 && currSum == BLACKJACK;
    }
}