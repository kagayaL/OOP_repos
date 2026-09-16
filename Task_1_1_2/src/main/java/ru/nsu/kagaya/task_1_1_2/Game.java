package ru.nsu.kagaya.task_1_1_2;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс для проведения игры.
 * Реализует процесс игры:
 * ход игрока, дилера, раунды.
 */
public class Game {
    private static final int AUTO_WIN_SCORE = 21;
    private static final int DEALER_BREAKPOINT = 17;

    Scanner scanner;
    Random random = new Random();
    Deck deck = new Deck();
    Someone player = new Someone("Player");
    Someone dealer = new Someone("Dealer");

    private int playerPoints = 0;
    private int dealerPoints = 0;
    private int round = 1;
    private boolean lastClosed = true;
    private Result result;

    /**
     * Конструктор, чтобы не было несколько сканеров.
     *
     * @param scanner общий сканер
     */
    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    private enum Result {
        PLAYER_WIN,
        DEALER_WIN,
        DRAW
    }

    private void dealTheCards() {
        // генерируем количество колод. В блекджеке от 1 до 8 обычно
        int deckCount = random.nextInt(1, 9);
        deck.createDeck(deckCount);
        player.hand = new Hand();
        dealer.hand = new Hand();
        System.out.println("Dealer deals the cards from " + deckCount
                + " decks");

        player.hand.getNewCard(deck.getNextCard());
        player.hand.getNewCard(deck.getNextCard());
        if (player.hand.currSum == AUTO_WIN_SCORE) {
            result = Result.PLAYER_WIN;
        }

        dealer.hand.getNewCard(deck.getNextCard());
        dealer.hand.getNewCard(deck.getNextCard());

        System.out.println(player.formatCards(false));
        System.out.println(dealer.formatCards(lastClosed));
    }

    private void playerTurn() {
        System.out.print("Your turn:\n--------------------\n");

        while (true) {
            System.out.println("Do you want get card (y/n):");
            String ans = scanner.nextLine();
            if (ans.equals("y")) {
                Card openedCard = deck.getNextCard();

                int aceLowBefore = player.hand.lowAceCnt;
                player.hand.getNewCard(openedCard);
                int aceLowAfter = player.hand.lowAceCnt;

                System.out.print("You get ");

                // Ace value check:
                boolean isAceLow = aceLowBefore != aceLowAfter;

                System.out.println(openedCard.formatCard(isAceLow));

                System.out.println(player.formatCards(false));
                System.out.println(dealer.formatCards(lastClosed));

                // check result
                if (player.hand.currSum > AUTO_WIN_SCORE) {
                    result = Result.DEALER_WIN;
                    break;
                } else if (player.hand.currSum == AUTO_WIN_SCORE) {
                    result = Result.PLAYER_WIN;
                    break;
                }
            } else if (ans.equals("n")) {
                break;
            } else {
                System.out.println("Wrong input, try again...");
            }
        }
    }

    private void dealerTurn() {
        System.out.print("Dealer turn:\n--------------------\n");
        openClosedCard();
        System.out.println(player.formatCards(false));
        System.out.println(dealer.formatCards(lastClosed));

        while (dealer.hand.currSum < DEALER_BREAKPOINT) {

            Card openedCard = deck.getNextCard();

            int aceLowBefore = dealer.hand.lowAceCnt;
            dealer.hand.getNewCard(openedCard);
            int aceLowAfter = dealer.hand.lowAceCnt;

            System.out.print("Dealer get ");

            // Ace value check:
            boolean isAceLow = aceLowBefore != aceLowAfter;

            System.out.println(openedCard.formatCard(isAceLow));

            System.out.println(player.formatCards(false));
            System.out.println(dealer.formatCards(lastClosed));

            // check result
            if (dealer.hand.currSum > AUTO_WIN_SCORE) {
                result = Result.PLAYER_WIN;
                break;
            } else if (dealer.hand.currSum == AUTO_WIN_SCORE) {
                result = Result.DEALER_WIN;
                break;
            }
        }
    }

    private void openClosedCard() {
        System.out.print("Dealer open closed card ");
        System.out.println(dealer.hand.cards[1].formatCard(false));
        lastClosed = false;
        System.out.println(dealer.formatCards(lastClosed));
        System.out.println();
    }

    /**
     * Реализует раунд по всем правилам блек джека.
     */
    public void doRound() {
        result = Result.DRAW;
        System.out.println("Round №" + round);
        dealTheCards();
        if (result != Result.DRAW) {
            printResult();
            return;
        }
        playerTurn();
        if (result != Result.DRAW) {
            printResult();
            return;
        }
        dealerTurn();
        if (result == Result.DRAW) {
            if (player.hand.currSum > dealer.hand.currSum) {
                result = Result.PLAYER_WIN;
            } else if (player.hand.currSum < dealer.hand.currSum) {
                result = Result.DEALER_WIN;
            }
        }
        printResult();
    }

    private void printResult() {
        lastClosed = true;
        round++;
        if (result == Result.PLAYER_WIN) {
            playerPoints++;
            System.out.printf("You win!\nYou - %d / %d - Dealer\n", playerPoints, dealerPoints);
        } else if (result == Result.DEALER_WIN) {
            dealerPoints++;
            System.out.printf("You lose!\nYou - %d / %d - Dealer\n", playerPoints, dealerPoints);
        } else {
            System.out.printf("Draw!\nYou - %d / %d - Dealer\n", playerPoints, dealerPoints);
        }
    }
}