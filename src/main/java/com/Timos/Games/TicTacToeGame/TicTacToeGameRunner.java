package com.Timos.Games.TicTacToeGame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicTacToeGameRunner extends GameRunner{

    @Autowired
    TicTacToeGame game;

    @Autowired
    ConsoleInputRetriever retriever;

    public void runTicTacToe() {
        super.run(game, retriever);
    }
}
