package ru.nsu.kagaya.Task_1_1_2;

import java.util.Random;

public class Deck {
    int currCardInd = 0;
    Card[] deck = new Card[52];



    public Card GetNextCard() {
        return deck[currCardInd++];
    }
    private void shuffleDeck() { //каждую карту в колоде меняю с другой рандомной картой
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int new_position = rand.nextInt(52);
            Card temp = deck[i];
            deck[i] = deck[new_position];
            deck[new_position] = temp;
        }
    }
    public void createDeck() {
        int ind = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck[ind++] = new Card(suit, rank);
            }
        }
        shuffleDeck();
    }

}
