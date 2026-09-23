package ru.nsu.kagaya.task112;

/**
 * Класс, реализующий карты.
 */
public class Card {

    private final Rank rank;
    private final Suit suit;

    /**
     * Конструктор для карты.
     *
     * @param suit масть
     * @param rank ранг
     */
    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Функция для генерации строки с рангом, названием
     * и весом карты.
     *
     * @param isAceLow булева переменная для определения веса туза
     * @return строка с картой
     */
    @Override
    public String toString(boolean isAceLow) {
        StringBuilder result = new StringBuilder();
        if (isAceLow) {
            result.append(String.format("%s %s ( 1 )", this.rank.name, this.suit.getName()));
        } else {
            result.append(String.format("%s %s ( %d )",
                    this.rank.name, this.suit.getName(), this.rank.value));
        }
        return result.toString();
    }

}