package com.Timos.Games.TicTacToeGame;

import com.Timos.Games.GameComponents.IGame;
import org.springframework.stereotype.Component;

@Component
public class TicTacToeGame implements IGame {

    private Board board;
    private CellState player;

    public TicTacToeGame(){
        board = new Board();
        player = CellState.O;
    }


}
