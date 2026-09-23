package ru.nsu.kagaya.task112;

import java.util.Random;

/**
 * Класс, реализующий один раунд игры:
 * раздача карт, ход игрока, ход дилера.
 */
public class Round {
    private final int number;
    private final Random random = new Random();
    private final ConsoleUI ui;
    private final Player player = new Player();
    private final Dealer dealer = new Dealer();
    private Deck deck;
    private RoundResult result = RoundResult.DRAW;
    private boolean dealerClosed = true;

    /**
     * Конструктор раунда.
     *
     * @param number номер раунда
     * @param ui     консольный ввод-вывод
     */
    public Round(int number, ConsoleUI ui) {
        this.number = number;
        this.ui = ui;
    }

    /**
     * Проводит раунд по правилам блэкджека.
     *
     * @return исход раунда
     */
    public RoundResult play() {
        ui.printRoundNumber(number);
        deal();
        if (result != RoundResult.DRAW) {
            return result;
        }
        playerTurn();
        if (result != RoundResult.DRAW) {
            return result;
        }
        dealerTurn();
        if (result == RoundResult.DRAW) {
            result = Rules.determineResult(player.getHand().getSum(), dealer.getHand().getSum());
        }
        return result;
    }

    /**
     * Раздача по две карты игроку и дилеру.
     */
    private void deal() {
        int deckCount = random.nextInt(Rules.MIN_DECKS, Rules.MAX_DECKS + 1);
        deck = new Deck(deckCount);
        ui.printDealInfo(deckCount);

        player.getHand().addCard(deck.getNextCard());
        player.getHand().addCard(deck.getNextCard());
        if (player.getHand().isBlackjack()) {
            result = RoundResult.PLAYER_WIN;
        }

        dealer.getHand().addCard(deck.getNextCard());
        dealer.getHand().addCard(deck.getNextCard());

        ui.printHands(player, dealer, dealerClosed);
    }

    /**
     * Ход игрока: открывает карты, пока не захочет остановиться.
     */
    private void playerTurn() {
        ui.printPlayerTurnHeader();
        while (result == RoundResult.DRAW && ui.wantsCard()) {
            Card openedCard = deck.getNextCard();
            boolean isAceLow = player.getHand().addCard(openedCard);
            ui.printOpenedCard("You", openedCard, isAceLow);
            ui.printHands(player, dealer, dealerClosed);

            if (player.getHand().isBust()) {
                result = RoundResult.DEALER_WIN;
            } else if (player.getHand().getSum() == Rules.BLACKJACK) {
                result = RoundResult.PLAYER_WIN;
            }
        }
    }

    /**
     * Ход дилера: открывает закрытую карту,
     * затем берет карты, пока сумма меньше 17.
     */
    private void dealerTurn() {
        ui.printDealerTurnHeader();
        revealClosedCard();
        ui.printHands(player, dealer, false);

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
    }

    /**
     * Открытие закрытой карты дилера.
     */
    private void revealClosedCard() {
        ui.printDealerRevealsClosed(dealer.getHand().getCard(1));
        dealerClosed = false;
    }
}