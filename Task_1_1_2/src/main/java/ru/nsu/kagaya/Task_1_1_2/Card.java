package ru.nsu.kagaya.Task_1_1_2;

public class Card {

    public enum Suit {
        CLUBS ("Clubs"),
        HEARTS ("Hearts"),
        SPADES ("Spades"),
        DIAMONDS ("Diamonds");

        private final String name;

        Suit(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
    public enum Rank {
        TWO(2, "Two"),
        THREE (3, "Three"),
        FOUR(4, "Four"),
        FIVE(5, "Five"),
        SIX(6, "Six"),
        SEVEN(7, "Seven"),
        EIGHT(8, "Eight"),
        NINE(9, "Nine"),
        TEN(10, "Ten"),
        KNIGHT(10, "Knight"),
        QUIN(10, "Quin"),
        KING(10, "King"),
        ACE(11, "Ace");

        private final int value;
        private final String name;

        Rank(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }
        public String getName() {
            return name;
        }
    }

    Card.Rank rank;
    Card.Suit suit;

    public String FormatCard(boolean is_ace_low) {
            StringBuilder result = new StringBuilder();
            if (is_ace_low) {
                result.append(String.format
                        ("%s %s ( 1 )", this.rank.name, this.suit.name));
            }
            else {
                result.append(String.format
                        ("%s %s ( %d )", this.rank.name, this.suit.name, this.rank.value));
            }
            return result.toString();
    }

    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }
}
