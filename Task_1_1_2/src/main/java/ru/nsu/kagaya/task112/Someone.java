package ru.nsu.kagaya.task112;

/**
 * Класс, реализующий сущность, владеющую картами.
 */
public abstract class Someone {
    private final Hand hand = new Hand();
    private final String name;

    /**
     * Конструктор, назначающий имя сущности.
     *
     * @param who имя сущности
     */
    public Someone(String who) {
        this.name = who;
    }

    /**
     * Рука сущности.
     *
     * @return руку
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Имя сущности.
     *
     * @return имя сущности
     */
    public String getName() {
        return name;
    }

    /**
     * Функция, генерирующая строку для вывода с рукой.
     *
     * @param lastClosed булевая переменная для закрытой карты у дилера
     * @return строка со всеми картами
     */
    public String toString(boolean lastClosed) {
        StringBuilder result = new StringBuilder();
        result.append(name).append("'s cards: [ ");
        int lowAceCnt = hand.getLowAceCnt();
        for (int i = 0; i < hand.getCardCount() - 1; i++) {
            boolean isAceLow = !lastClosed
                    && (hand.getCard(i).getRank() == Rank.ACE)
                    && (lowAceCnt-- > 0);

            result.append(hand.getCard(i).toString(isAceLow)).append(", ");
        }
        if (lastClosed) {
            result.append("<closed> ] => ?");
        } else {
            boolean isAceLow = (hand.getCard(hand.getCardCount() - 1).getRank() == Rank.ACE)
                    && (lowAceCnt-- > 0);
            result.append(hand.getCard(hand.getCardCount() - 1).toString(isAceLow));
            result.append(" ] => ").append(hand.getSum());
        }
        return result.toString();
    }
}