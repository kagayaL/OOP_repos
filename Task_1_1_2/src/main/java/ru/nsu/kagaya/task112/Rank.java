package ru.nsu.kagaya.task112;

/**
 * Ранг и стоимость карты.
 */
public enum Rank {
    TWO(2, "Two"),
    THREE(3, "Three"),
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

    /**
     * Стоимость карты в 21
     *
     * @return стоимость карты в 21
     */
    public int getValue() {
        return value;
    }

    /**
     * Имя ранга карты
     *
     * @return имя ранга карты
     */
    public String getName() {
        return name;
    }
}