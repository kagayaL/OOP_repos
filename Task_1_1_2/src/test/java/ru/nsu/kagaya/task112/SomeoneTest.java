package ru.nsu.kagaya.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeoneTest {

    @Test
    void twoAcePlayer() {
        Someone player = new Someone("Player");
        player.hand.getNewCard(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        player.hand.getNewCard(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        assertEquals(player.formatCards(false),
                "Player's cards: [ Ace Clubs ( 1 ), Ace Diamonds ( 11 ) ] => 12");
    }

    @Test
    void twoAceDealer() {
        Someone player = new Someone("Dealer");
        player.hand.getNewCard(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        player.hand.getNewCard(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        assertEquals(player.formatCards(true),
                "Dealer's cards: [ Ace Clubs ( 11 ), <closed> ] => ?");
    }

    @Test
    void defaultCard() {
        Someone player = new Someone("Player");
        player.hand.getNewCard(new Card(Card.Suit.CLUBS, Card.Rank.KING));
        player.hand.getNewCard(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));
        player.hand.getNewCard(new Card(Card.Suit.HEARTS, Card.Rank.TWO));
        assertEquals(player.formatCards(false),
                "Player's cards: [ King Clubs ( 10 ), Eight Diamonds ( 8 ),"
                       + " Two Hearts ( 2 ) ] => 20");
    }

}