package ru.nsu.kagaya.Task_1_1_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @ParameterizedTest
    @CsvSource({
        "1, 52",
        "2, 104",
        "10, 520"
    })
    void cardCount(int deckCount, int expectedCards) {
        deck.createDeck(deckCount);

        int actual = 0;
        for (int i = 0; i < expectedCards; i++) {
            assertNotNull(deck.getNextCard());
            actual++;
        }
        assertEquals(expectedCards, actual);
    }

    @Test
    void getNextCard() {
        deck.createDeck(1);

        Card nextCard = deck.getNextCard();
        assertEquals(deck.deck[0], nextCard);

        nextCard = deck.getNextCard();
        assertEquals(deck.deck[1], nextCard);

        nextCard = deck.getNextCard();
        assertEquals(deck.deck[2], nextCard);
    }
}