package ru.nsu.kagaya.Task_1_1_2;

/**
 * Класс реализующий сущность владеющую картами
 */
public class Someone {
    Hand hand = new Hand();
    String who;

    /**
     * Конструктор назначающий имя сущности
     * @param who имя сущности
     */
    public Someone(String who) {
        this.who = who;
    }

    /**
     * Функция генерерующая строку для вывода с рукой
     * @param last_closed булевая переменная для закрытой карты у дилера
     * @return строка со всеми картами
     */
    public String FormatCards(boolean last_closed) {
        StringBuilder result = new StringBuilder();
        result.append(who + "'s cards: [ ");
        int lowAceCnt = hand.LowAceCnt;
        for (int i = 0; i < hand.cardCount - 1; i++) {
            boolean is_ace_low = !last_closed &&
                    (hand.cards[i].rank == Card.Rank.ACE) && (lowAceCnt-- > 0);

            result.append(hand.cards[i].FormatCard(is_ace_low) + ", ");
        }
        if (last_closed) {
            result.append("<closed> ] => ?");
        }
        else {
            boolean is_ace_low = (hand.cards[hand.cardCount - 1].rank == Card.Rank.ACE) && (lowAceCnt-- > 0);
            result.append(hand.cards[hand.cardCount - 1].FormatCard(is_ace_low));
            result.append(" ] => " + hand.currSum);
        }
        return result.toString();
    }
}
