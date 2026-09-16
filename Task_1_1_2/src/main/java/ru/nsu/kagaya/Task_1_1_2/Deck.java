package ru.nsu.kagaya.Task_1_1_2;

import java.util.Random;

/**
 * Класс для создания колоды.
 */
public class Deck {
    private static final int DECK_SIZE = 52;
    private Card[] deck;
    private int deckCount;
    private int currCardInd = 0;
    private final Random rand = new Random();

    /**
     * Достает следующую карту.
     *
     * @return следующую карту
     */
    public Card getNextCard() {
        return deck[currCardInd++];
    }

    private void shuffleDeck() {
        // каждую карту в колоде меняю с другой рандомной картой
        int total = DECK_SIZE * deckCount;

        for (int i = 0; i < total; i++) {
            int newPosition = rand.nextInt(total);
            Card temp = deck[i];
            deck[i] = deck[newPosition];
            deck[newPosition] = temp;
        }
    }

    /**
     * Создает перемешанную колоду из заданного числа колод.
     *
     * @param deckCount количество колод
     */
    public void createDeck(int deckCount) {
        this.currCardInd = 0;
        this.deckCount = deckCount;
        this.deck = new Card[DECK_SIZE * deckCount];

        int ind = 0;
        for (int i = 0; i < deckCount; i++) {
            for (Card.Suit suit : Card.Suit.values()) {
                for (Card.Rank rank : Card.Rank.values()) {
                    deck[ind++] = new Card(suit, rank);
                }
            }
        }
        shuffleDeck();
    }
}