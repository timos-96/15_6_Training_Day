package com.Timos.Games.TicTacToeGame;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    public static void run(TicTacToeGame game, ConsoleInputRetriever retriever) {

        Integer input = null;
        boolean isValidInput = false;
        boolean isGameOver = false;

        System.out.println("Starting the game");

        while (!isGameOver) {
            while (!isValidInput) {
                input = retriever.retrieveInput(System.in).orElse(null);
                if (input == null) {
                    isValidInput = false;
                } else {
                    isValidInput = game.isInputValidForGame(input);
                }
            }

            isValidInput = true;

            game.placeMoveOnBoard(input);

            game.showGame();

            isGameOver = game.isGameFinished();
        }
    }
}
