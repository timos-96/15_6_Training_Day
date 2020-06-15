package com.Timos.Games.TicTacToeGame;

import com.Timos.Games.GameComponents.IGame;
import com.Timos.Games.GameComponents.IInputRetriever;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    public static void run(IGame game, IInputRetriever retriever){

        Integer input;
        Boolean isValidInput = true;

        System.out.println("Starting the game");

        while(isValidInput){
            input = retriever.retrieveInput(System.in);
            isValidInput = !game.isInputValidForGame(input);
        }

        game.isGameFinished();
    }
}
