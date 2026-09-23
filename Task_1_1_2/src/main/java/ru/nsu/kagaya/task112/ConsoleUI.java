package ru.nsu.kagaya.task112;

import java.util.Scanner;

/**
 * Класс для консольного ввода-вывода.
 */
public class ConsoleUI {
    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Номер раунда.
     *
     * @param roundNumber номер раунда
     */
    public void printRoundNumber(int roundNumber) {
        System.out.println("Round №" + roundNumber);
    }

    /**
     * Сообщение о раздаче из нескольких колод.
     *
     * @param deckCount количество колод
     */
    public void printDealInfo(int deckCount) {
        System.out.println("Dealer deals the cards from " + deckCount + " decks");
    }

    /**
     * Вывод рук игрока и дилера.
     *
     * @param player       игрок
     * @param dealer       дилер
     * @param dealerClosed закрыта ли карта дилера
     */
    public void printHands(Someone player, Someone dealer, boolean dealerClosed) {
        System.out.println(player.toString(false));
        System.out.println(dealer.toString(dealerClosed));
    }

    public void printPlayerTurnHeader() {
        System.out.print("Your turn:\n--------------------\n");
    }

    public void printDealerTurnHeader() {
        System.out.print("Dealer turn:\n--------------------\n");
    }

    /**
     * Сообщение об открытой карте.
     *
     * @param who       кто открыл карту ("You" или "Dealer")
     * @param card      открытая карта
     * @param isAceLow  считается ли туз за 1 очко
     */
    public void printOpenedCard(String who, Card card, boolean isAceLow) {
        System.out.print(who + " get ");
        System.out.println(card.toString(isAceLow));
    }

    /**
     * Дилер открывает закрытую карту.
     *
     * @param card закрытая карта дилера
     */
    public void printDealerRevealsClosed(Card card) {
        System.out.print("Dealer open closed card ");
        System.out.println(card.toString(false));
        System.out.println();
    }

    /**
     * Хочет ли игрок взять еще одну карту.
     *
     * @return true, если игрок берет карту
     */
    public boolean wantsCard() {
        while (true) {
            System.out.println("Do you want get card (y/n):");
            String ans = scanner.nextLine();
            if (ans.equals("y")) {
                return true;
            }
            if (ans.equals("n")) {
                return false;
            }
            System.out.println("Wrong input, try again...");
        }
    }

    /**
     * Хочет ли игрок сыграть еще один раунд.
     *
     * @return true, если игрок хочет сыграть раунд
     */
    public boolean wantsNextRound() {
        while (true) {
            System.out.println("Play round? (y/n):");
            String ans = scanner.nextLine();
            if (ans.equals("y")) {
                return true;
            }
            if (ans.equals("n")) {
                return false;
            }
            System.out.println("Wrong input. Try again...");
        }
    }

    /**
     * Вывод результата раунда и счета.
     *
     * @param result       исход раунда
     * @param playerScore  очки игрока
     * @param dealerScore  очки дилера
     */
    public void printScore(RoundResult result, int playerScore, int dealerScore) {
        if (result == RoundResult.PLAYER_WIN) {
            System.out.printf("You win!\nYou - %d / %d - Dealer\n", playerScore, dealerScore);
        } else if (result == RoundResult.DEALER_WIN) {
            System.out.printf("You lose!\nYou - %d / %d - Dealer\n", playerScore, dealerScore);
        } else {
            System.out.printf("Draw!\nYou - %d / %d - Dealer\n", playerScore, dealerScore);
        }
    }
}