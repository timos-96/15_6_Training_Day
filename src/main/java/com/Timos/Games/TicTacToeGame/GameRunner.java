package com.Timos.Games.TicTacToeGame;

import com.Timos.Games.GameComponents.IGame;
import com.Timos.Games.GameComponents.IInputRetriever;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    public static void run(IGame game, IInputRetriever retriever){

        Integer input = null;
        Boolean isNotValidInput = true;
        Boolean isNotGameOver = true;

        System.out.println("Starting the game");

        while(isNotGameOver) {
            while (isNotValidInput) {
                input = retriever.retrieveInput(System.in);
                if(input == null){
                    isNotValidInput = true;
                }
                else {
                    isNotValidInput = !game.isInputValidForGame(input);
                }
            }

            isNotValidInput = true;

            game.placeMoveOnBoard(input);

            game.showGame();

            isNotGameOver= !game.isGameFinished();
        }
    }
}
