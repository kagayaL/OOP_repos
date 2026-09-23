package ru.nsu.kagaya.task112;

/**
 * Класс для проведения игры:
 * запускает раунды и ведет счет.
 */
public class Game {
    private final ConsoleUI ui;
    private int playerScore = 0;
    private int dealerScore = 0;
    private int roundNumber = 0;

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
        while (ui.wantsNextRound()) {
            nextRound();
        }
    }

    /**
     * Проводит один раунд и обновляет счет.
     */
    public void nextRound() {
        roundNumber++;
        RoundResult result = new Round(roundNumber, ui).play();
        if (result == RoundResult.PLAYER_WIN) {
            playerScore++;
        } else if (result == RoundResult.DEALER_WIN) {
            dealerScore++;
        }
        ui.printScore(result, playerScore, dealerScore);
    }
}