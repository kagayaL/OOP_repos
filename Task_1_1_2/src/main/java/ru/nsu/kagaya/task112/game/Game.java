package ru.nsu.kagaya.task112.game;

import ru.nsu.kagaya.task112.ui.ConsoleUI;

/**
 * Класс для проведения игры:
 * запускает раунды и ведет счет.
 */
public class Game {
    private final ConsoleUI ui;
    private int playerScore = 0;
    private int dealerScore = 0;

    /**
     * Конструктор.
     *
     * @param ui консольный ввод-вывод
     */
    public Game(ConsoleUI ui) {
        this.ui = ui;
    }

    /**
     * Проводит раунды по желанию пользователя.
     */
    public void run() {
        int roundNumber = 1;
        while (ui.wantsNextRound()) {
            nextRound(roundNumber++);
        }
    }

    /**
     * Проводит один раунд и обновляет счет.
     */
    private void nextRound(int roundNumber) {

        RoundResult result = new Round(ui).play(roundNumber);
        if (result == RoundResult.PLAYER_WIN) {
            playerScore++;
        } else if (result == RoundResult.DEALER_WIN) {
            dealerScore++;
        }
        ui.printScore(result, playerScore, dealerScore);
    }
}