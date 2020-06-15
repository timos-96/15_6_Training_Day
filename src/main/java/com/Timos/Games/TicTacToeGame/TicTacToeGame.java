package com.Timos.Games.TicTacToeGame;

import com.Timos.Games.GameComponents.IGame;
import org.springframework.stereotype.Component;

@Component
public class TicTacToeGame implements IGame {

    private Board board;
    private CellState player = CellState.O;

    public TicTacToeGame(){
        board = new Board();
        player = CellState.O;
    }

    public Boolean isInputValidForGame (Integer input)  {
        return board.isInputValid(input);
    }

    public void placeMoveOnBoard(Integer input){
        board.placeMove(input, player);
        player = player == CellState.O ? CellState.X : CellState.O;
    }

    public void showGame(){
        board.showBoard();
    }

    public Boolean isGameFinished(){
        return board.isFinished();
    }
}
