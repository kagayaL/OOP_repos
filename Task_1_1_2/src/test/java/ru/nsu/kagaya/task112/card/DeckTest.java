package ru.nsu.kagaya.task112.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class DeckTest {

    @ParameterizedTest
    @CsvSource({
        "1, 52",
        "2, 104",
        "10, 520"
    })
    void cardCount(int deckCount, int expectedCards) {
        Deck deck = new Deck(deckCount);

        int actual = 0;
        for (int i = 0; i < expectedCards; i++) {
            assertNotNull(deck.getNextCard());
            actual++;
        }
        assertEquals(expectedCards, actual);
    }

    @Test
    void getNextCard() {
        Deck deck = new Deck(1);
        List<Card> cards = deck.getDeck();

        assertEquals(cards.get(0), deck.getNextCard());
        assertEquals(cards.get(1), deck.getNextCard());
        assertEquals(cards.get(2), deck.getNextCard());
    }
}