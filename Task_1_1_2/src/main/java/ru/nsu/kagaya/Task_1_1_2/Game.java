package ru.nsu.kagaya.Task_1_1_2;

import java.util.Random;
import java.util.Scanner;


public class Game {
    Random random = new Random();
    int player_points = 0;
    int dealer_points = 0;
    Deck deck = new Deck();
    int round = 1;
    boolean last_closed = true;
    Someone player = new Someone("Player");
    Someone dealer = new Someone("Dealer");

    private enum Result {
        PLAYER_WIN,
        DEALER_WIN,
        DRAW
    }
    Result result;

    private void dealTheCards() {
        //генерируем количество колод. В блекджеке от 1 до 8 обычно
        int deck_count = random.nextInt(1,9);
        deck.createDeck(deck_count);
        player.hand = new Hand();
        dealer.hand = new Hand();
        System.out.println("Dealer deals the cards from " + deck_count
                + " decks");

        player.hand.getNewCard(deck.getNextCard());
        player.hand.getNewCard(deck.getNextCard());
        if (player.hand.currSum == 21) {
            result = Result.PLAYER_WIN;
        }

        dealer.hand.getNewCard(deck.getNextCard());
        dealer.hand.getNewCard(deck.getNextCard());

        System.out.println(player.FormatCards(false));
        System.out.println(dealer.FormatCards(last_closed));
    }
    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your turn:\n--------------------\n");

        while (true) {
            System.out.println("Do you want get card (y/n):");
            String ans = scanner.nextLine();
            if (ans.equals("y")) {
                Card OpenedCard = deck.getNextCard();

                int AceLowBefore = player.hand.LowAceCnt;
                player.hand.getNewCard(OpenedCard);
                int AceLowAfter = player.hand.LowAceCnt;

                System.out.print("You get ");

                //Ace value check:
                boolean is_ace_low = AceLowBefore != AceLowAfter;

                System.out.println(OpenedCard.FormatCard(is_ace_low));

                System.out.println(player.FormatCards(false));
                System.out.println(dealer.FormatCards(last_closed));

                //check result
                if (player.hand.currSum > 21) {
                    result = Result.DEALER_WIN;
                    break;
                }
                else if (player.hand.currSum == 21) {
                    result = Result.PLAYER_WIN;
                    break;
                }
            }
            else if (ans.equals("n")) {
                break;
            }
            else {
                System.out.println("Wrong input, try again...");
            }
        }

    }
    private void dealerTurn() {
        System.out.print("Dealer turn:\n--------------------\n");
        openClosedCard();
        System.out.println(player.FormatCards(false));
        System.out.println(dealer.FormatCards(last_closed));

        while (dealer.hand.currSum < 17) {

            Card OpenedCard = deck.getNextCard();

            int AceLowBefore = dealer.hand.LowAceCnt;
            dealer.hand.getNewCard(OpenedCard);
            int AceLowAfter = dealer.hand.LowAceCnt;

            System.out.print("Dealer get ");

            //Ace value check:
            boolean is_ace_low = AceLowBefore != AceLowAfter;

            System.out.println(OpenedCard.FormatCard(is_ace_low));

            System.out.println(player.FormatCards(false));
            System.out.println(dealer.FormatCards(last_closed));

            //check result
            if (dealer.hand.currSum > 21 ) {
                result = Result.PLAYER_WIN;
                break;
            }
            else if (dealer.hand.currSum == 21) {
                result = Result.DEALER_WIN;
                break;
            }


        }
    }
    public void openClosedCard() {
        System.out.print("Dealer open closed card ");
        System.out.println(dealer.hand.cards[1].FormatCard(false));
        last_closed = false;
        System.out.println(dealer.FormatCards(last_closed));
        System.out.println();
    }
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
            }
            else if (player.hand.currSum < dealer.hand.currSum) {
                result = Result.DEALER_WIN;
            }
        }
        printResult();

    }
    public void printResult() {
        last_closed = true;
        round++;
        if (result == Result.PLAYER_WIN) {
            player_points++;
            System.out.printf("You win!\nYou - %d / %d - Dealer\n", player_points, dealer_points);
        }
        else if (result == Result.DEALER_WIN) {
            dealer_points++;
            System.out.printf("You lose!\n You - %d / %d - Dealer\n", player_points, dealer_points);
        }
        else {
            System.out.printf("Draw!\nYou - %d / %d - Dealer\n", player_points, dealer_points);
        }
    }
}
