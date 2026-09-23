package ru.nsu.kagaya.task112;

/**
 * Масти карт.
 */
public enum Suit {
    CLUBS("Clubs"),
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    /**
     * Название масти
     *
     * @return название масти
     */
    public String getName() {
        return name;
    }
}
