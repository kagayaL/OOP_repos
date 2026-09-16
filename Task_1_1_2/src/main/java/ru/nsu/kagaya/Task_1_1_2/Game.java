package ru.nsu.kagaya.Task_1_1_2;

import java.util.Scanner;


public class Game {
    int player_points = 0;
    int dealer_points = 0;
    Deck deck = new Deck();
    int round = 1;
    boolean is_first = true;
    boolean last_closed = true;
    Someone player = new Someone("Player");
    Someone dealer = new Someone("Dealer");

    public enum Result {
        PLAYER_WIN,
        DEALER_WIN,
        DRAW
    }
    Result result;
    private void DealTheCards() {
        deck.createDeck();
        player.hand = new Hand();
        dealer.hand = new Hand();
        System.out.println("Dealer deal the cards");
        player.hand.getNewCard(deck.GetNextCard());
        player.hand.getNewCard(deck.GetNextCard());
        if (player.hand.currSum == 21) {
            result = Result.PLAYER_WIN;
        }
        dealer.hand.getNewCard(deck.GetNextCard());
        dealer.hand.getNewCard(deck.GetNextCard());
        System.out.println(player.FormatCards(false));
        System.out.println(dealer.FormatCards(last_closed));
    }
    private void PlayerTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your turn:\n--------------------\n");

        while (true) {
            System.out.println("Do you want get card (y/n):");
            String ans = scanner.nextLine();
            if (ans.equals("y")) {
                Card OpenedCard = deck.GetNextCard();

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
    private void DealerTurn() {
        System.out.print("Dealer turn:\n--------------------\n");
        OpenClosedCard();
        System.out.println(player.FormatCards(false));
        System.out.println(dealer.FormatCards(last_closed));

        while (dealer.hand.currSum < 17) {

            Card OpenedCard = deck.GetNextCard();

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
    public void OpenClosedCard() {
        System.out.print("Dealer open closed card ");
        System.out.println(dealer.hand.cards[1].FormatCard(false));
        last_closed = false;
        System.out.println(dealer.FormatCards(last_closed));
        System.out.println();
    }
    public void DoRound() {
        result = Result.DRAW;
        System.out.println("Round №" + round);
        DealTheCards();
        if (result != Result.DRAW) {
            PrintResult();
            return;
        }
        PlayerTurn();
        if (result != Result.DRAW) {
            PrintResult();
            return;
        }
        DealerTurn();
        if (result == Result.DRAW) {
            if (player.hand.currSum > dealer.hand.currSum) {
               result = Result.PLAYER_WIN;
            }
            else if (player.hand.currSum < dealer.hand.currSum) {
                result = Result.DEALER_WIN;
            }
        }
        PrintResult();

    }
    public void PrintResult() {
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
