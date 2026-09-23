package ru.nsu.kagaya.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeoneTest {

    @Test
    void twoAcePlayer() {
        Player player = new Player();
        player.getHand().addCard(new Card(Suit.CLUBS, Rank.ACE));
        player.getHand().addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        assertEquals(player.toString(false),
                "Player's cards: [ Ace Clubs ( 1 ), Ace Diamonds ( 11 ) ] => 12");
    }

    @Test
    void twoAceDealer() {
        Dealer dealer = new Dealer();
        dealer.getHand().addCard(new Card(Suit.CLUBS, Rank.ACE));
        dealer.getHand().addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        assertEquals(dealer.toString(true),
                "Dealer's cards: [ Ace Clubs ( 11 ), <closed> ] => ?");
    }

    @Test
    void defaultCard() {
        Player player = new Player();
        player.getHand().addCard(new Card(Suit.CLUBS, Rank.KING));
        player.getHand().addCard(new Card(Suit.DIAMONDS, Rank.EIGHT));
        player.getHand().addCard(new Card(Suit.HEARTS, Rank.TWO));
        assertEquals(player.toString(false),
                "Player's cards: [ King Clubs ( 10 ), Eight Diamonds ( 8 ),"
                       + " Two Hearts ( 2 ) ] => 20");
    }

}