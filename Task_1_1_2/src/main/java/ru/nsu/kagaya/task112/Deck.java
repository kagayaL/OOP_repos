package ru.nsu.kagaya.task112;

import java.util.Random;

/**
 * Класс для создания колоды.
 */
public class Deck {
    private static final int DECK_SIZE = 52;
    private final Card[] deck;
    private int currentCardInd = 0;


    /**
     * Достает следующую карту.
     *
     * @return следующую карту
     */
    public Card getNextCard() {
        return deck[currentCardInd++];
    }

    /**
     * Выдает колоду
     *
     * @return колода с картами
     */
    public Card[] getDeck() {
        return deck;
    }

    private void shuffleDeck() {
        // каждую карту в колоде меняю с другой рандомной картой
        Random rand = new Random();
        int total = deck.length;

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
    public Deck(int deckCount) {
        this.currentCardInd = 0;
        this.deck = new Card[DECK_SIZE * deckCount];

        int ind = 0;
        for (int i = 0; i < deckCount; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck[ind++] = new Card(suit, rank);
                }
            }
        }
        shuffleDeck();
    }
}