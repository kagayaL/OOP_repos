package ru.nsu.kagaya.task112.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс для создания колоды.
 */
public class Deck {
    private static final int DECK_SIZE = 52;
    private final List<Card> deck;
    private int currentCardInd = 0;


    /**
     * Достает следующую карту.
     *
     * @return следующую карту
     */
    public Card getNextCard() {
        return deck.get(currentCardInd++);
    }

    /**
     * Выдает колоду
     *
     * @return колода с картами
     */
    public List<Card> getDeck() {
        return deck;
    }

    private void shuffleDeck() {
        // каждую карту в колоде меняю с другой рандомной картой
        Random random = new Random();
        int total = deck.size();

        for (int i = 0; i < total; i++) {
            int newPosition = random.nextInt(total);
            Card temp = deck.get(i);
            deck.set(i, deck.get(newPosition));
            deck.set(newPosition, temp);
        }
    }

    /**
     * Создает перемешанную колоду из заданного числа колод.
     *
     * @param deckCount количество колод
     */
    public Deck(int deckCount) {
        this.currentCardInd = 0;
        this.deck = new ArrayList<>(DECK_SIZE * deckCount);

        int ind = 0;
        for (int i = 0; i < deckCount; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
        shuffleDeck();
    }
}