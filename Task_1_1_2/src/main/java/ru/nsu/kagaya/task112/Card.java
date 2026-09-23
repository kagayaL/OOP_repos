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

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    /**
     * Функция для генерации строки с рангом, названием
     * и весом карты.
     *
     * @param isAceLow булева переменная для определения веса туза
     * @return строка с картой
     */
    public String cardToString(boolean isAceLow) {
        StringBuilder result = new StringBuilder();
        if (isAceLow) {
            result.append(String.format("%s %s ( 1 )", rank.getName(), suit.getName()));
        } else {
            result.append(String.format("%s %s ( %d )",
                    rank.getName(), suit.getName(), rank.getValue()));
        }
        return result.toString();
    }

}