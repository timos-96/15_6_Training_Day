package com.Timos.Games.TicTacToeGame;

import com.Timos.Games.GameComponents.IGame;
import com.Timos.Games.GameComponents.IInputRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    public static void run(IGame game, IInputRetriever retriever){

        System.out.println("Starting the game");
        retriever.retrieveInput(System.in);
    }
}
