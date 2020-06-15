package com.Timos.Games.TicTacToeGame;

import com.Timos.Games.GameComponents.IGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    @Autowired
    TicTacToeGame game;

    public void run(IGame game){

        System.out.println("Starting the game");
    }
}
