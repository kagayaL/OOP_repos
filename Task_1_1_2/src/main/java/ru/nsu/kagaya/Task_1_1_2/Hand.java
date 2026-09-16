package ru.nsu.kagaya.Task_1_1_2;

import static ru.nsu.kagaya.Task_1_1_2.Card.Rank.ACE;

public class Hand {
    Card[] cards = new Card[52];
    int cardCount = 0;
    int currSum = 0;
    int HighAceCnt = 0;
    int LowAceCnt = 0;

    public void getNewCard(Card card) {
        cards[cardCount++] = card;
        if (card.rank == ACE) {
            HighAceCnt++;
        }
        currSum += card.rank.getValue();
        if (currSum > 21 && HighAceCnt > 0) {
            currSum -= 10;
            HighAceCnt--;
            LowAceCnt++;
        }
    }
    public int getSum() {
        return currSum;
    }
}
