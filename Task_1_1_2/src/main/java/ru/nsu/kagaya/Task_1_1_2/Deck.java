package ru.nsu.kagaya.Task_1_1_2;

import java.util.Random;


public class Deck {
    private static final int DECK_SIZE = 52;
    Card[] deck;
    int deck_count;
    int currCardInd = 0;
    Random rand = new Random();

    public Card getNextCard() {
        return deck[currCardInd++];
    }
    private void shuffleDeck() { //каждую карту в колоде меняю с другой рандомной картой
        int total = DECK_SIZE * deck_count;

        for (int i = 0; i < total; i++) {
            int new_position = rand.nextInt(total);
            Card temp = deck[i];
            deck[i] = deck[new_position];
            deck[new_position] = temp;
        }
    }
    public void createDeck( int deck_cnt) {
        int ind = 0;
        currCardInd = 0;
        deck_count = deck_cnt;
        deck = new Card[DECK_SIZE * deck_count];

        for (int i = 0; i < deck_count; i++) {
            for (Card.Suit suit : Card.Suit.values()) {
                for (Card.Rank rank : Card.Rank.values()) {
                    deck[ind++] = new Card(suit, rank);
                }
            }
        }
        shuffleDeck();
    }

}
