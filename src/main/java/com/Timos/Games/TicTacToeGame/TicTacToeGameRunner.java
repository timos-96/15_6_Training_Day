package com.Timos.Games.TicTacToeGame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TicTacToeGameRunner extends GameRunner{

    @Autowired
    private TicTacToeGame game;

    @Autowired
    private ConsoleInputRetriever retriever;

//    @PostConstruct
    public void runTicTacToe() {
        super.run(game, retriever);
    }
}
