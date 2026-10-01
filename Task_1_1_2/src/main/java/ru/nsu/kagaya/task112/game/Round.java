package ru.nsu.kagaya.task112.game;

import ru.nsu.kagaya.task112.card.Card;
import ru.nsu.kagaya.task112.card.Deck;
import ru.nsu.kagaya.task112.player.Dealer;
import ru.nsu.kagaya.task112.player.Player;
import ru.nsu.kagaya.task112.ui.ConsoleUI;

import java.util.Random;

/**
 * Класс, реализующий один раунд игры:
 * раздача карт, ход игрока, ход дилера.
 */
public class Round {
    private final ConsoleUI ui;
    private final Player player = new Player();
    private final Dealer dealer = new Dealer();
    private Deck deck;


    /**
     * Конструктор раунда.
     *
     * @param ui     консольный ввод-вывод
     */
    public Round( ConsoleUI ui) {
        this.ui = ui;
    }

    /**
     * Проводит раунд по правилам блэкджека.
     *
     * @return исход раунда
     */
    public RoundResult play(int roundNumber) {
        ui.printRoundNumber(roundNumber);

        RoundResult result = deal();
        if (result != RoundResult.DRAW) {
            return result;
        }
        result = playerTurn();
        if (result != RoundResult.DRAW) {
            return result;
        }
        result = dealerTurn();
        if (result == RoundResult.DRAW) {
            result = Rules.determineResult(player.getHand().getSum(), dealer.getHand().getSum());
        }
        return result;
    }

    /**
     * Раздача по две карты игроку и дилеру.
     */
    private RoundResult deal() {
        Random random = new Random();

        int deckCount = random.nextInt(Rules.MIN_DECKS, Rules.MAX_DECKS + 1);
        deck = new Deck(deckCount);

        ui.printDealInfo(deckCount);

        player.getHand().addCard(deck.getNextCard());
        player.getHand().addCard(deck.getNextCard());
        if (player.getHand().isBlackjack()) {
            return RoundResult.PLAYER_WIN;
        }

        dealer.getHand().addCard(deck.getNextCard());
        dealer.getHand().addCard(deck.getNextCard());

        ui.printHands(player, dealer, true);

        return RoundResult.DRAW;
    }

    /**
     * Ход игрока: открывает карты, пока не захочет остановиться.
     */
    private RoundResult playerTurn() {
        ui.printPlayerTurnHeader();
        RoundResult result = RoundResult.DRAW;
        while (result == RoundResult.DRAW && ui.wantsCard()) {
            Card openedCard = deck.getNextCard();
            boolean isAceLow = player.getHand().addCard(openedCard);
            ui.printOpenedCard("You", openedCard, isAceLow);
            ui.printHands(player, dealer, true);

            if (player.getHand().isBust()) {
                result = RoundResult.DEALER_WIN;
            } else if (player.getHand().getSum() == Rules.BLACKJACK) {
                result = RoundResult.PLAYER_WIN;
            }
        }
        return result;
    }

    /**
     * Ход дилера: открывает закрытую карту,
     * затем берет карты, пока сумма меньше 17.
     */
    private RoundResult dealerTurn() {
        ui.printDealerTurnHeader();
        revealClosedCard();
        ui.printHands(player, dealer, false);

        RoundResult result = RoundResult.DRAW;

        while (dealer.shouldTakeCard()) {
            Card openedCard = deck.getNextCard();
            boolean isAceLow = dealer.getHand().addCard(openedCard);
            ui.printOpenedCard("Dealer", openedCard, isAceLow);
            ui.printHands(player, dealer, false);

            if (dealer.getHand().isBust()) {
                result = RoundResult.PLAYER_WIN;
            } else if (dealer.getHand().getSum() == Rules.BLACKJACK) {
                result = RoundResult.DEALER_WIN;
            }
        }
        return result;
    }

    /**
     * Открытие закрытой карты дилера.
     */
    private void revealClosedCard() {
        ui.printDealerRevealsClosed(dealer.getHand().getCard(1));
    }
}