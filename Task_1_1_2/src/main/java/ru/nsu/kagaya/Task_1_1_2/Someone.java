package ru.nsu.kagaya.Task_1_1_2;

/**
 * Класс, реализующий сущность, владеющую картами.
 */
public class Someone {
    Hand hand = new Hand();
    String who;

    /**
     * Конструктор, назначающий имя сущности.
     *
     * @param who имя сущности
     */
    public Someone(String who) {
        this.who = who;
    }

    /**
     * Функция, генерирующая строку для вывода с рукой.
     *
     * @param lastClosed булевая переменная для закрытой карты у дилера
     * @return строка со всеми картами
     */
    public String formatCards(boolean lastClosed) {
        StringBuilder result = new StringBuilder();
        result.append(who + "'s cards: [ ");
        int lowAceCnt = hand.lowAceCnt;
        for (int i = 0; i < hand.cardCount - 1; i++) {
            boolean isAceLow = !lastClosed
                    && (hand.cards[i].rank == Card.Rank.ACE)
                    && (lowAceCnt-- > 0);

            result.append(hand.cards[i].formatCard(isAceLow) + ", ");
        }
        if (lastClosed) {
            result.append("<closed> ] => ?");
        } else {
            boolean isAceLow = (hand.cards[hand.cardCount - 1].rank == Card.Rank.ACE)
                    && (lowAceCnt-- > 0);
            result.append(hand.cards[hand.cardCount - 1].formatCard(isAceLow));
            result.append(" ] => " + hand.currSum);
        }
        return result.toString();
    }
}