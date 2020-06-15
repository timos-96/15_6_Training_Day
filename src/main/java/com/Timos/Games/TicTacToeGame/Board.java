package com.Timos.Games.TicTacToeGame;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class Board {

    private List<Cell> cells;
    private final Integer[][] winningCombinations = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    private final Integer boardSize = 9;

    public Board(){
       cells = new ArrayList<Cell>();
       IntStream.rangeClosed(1, boardSize).forEach(i -> cells.add(new Cell()));
    }

    public Boolean isInputValid(Integer input) {
        try {
            if (input < 0 || input > cells.size()) {
                throw new IndexOutOfBoundsException("Please re-enter move");
            } else if (cells.get(input).cellState == CellState.NOT_TAKEN) {
                return true;
            } else {
                return false;
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e);
            return false;
        }
    }

    public void placeMove(Integer input, CellState symbol){
        getCells().get(input).setCellState(symbol);
        System.out.println("Move placed on cell " + input);
    }

    public void showBoard(){
        for (int i = 0; i < getCells().size(); i++) {
            System.out.println(getCells().get(i).getCellState());
        }
    }

    public Boolean isFinished(){
        return (isDraw() || isWin());
    }

    private Boolean isWin(){
        for (int i = 0; i < winningCombinations.length; i++) {
            Integer[] winningCombination = winningCombinations[i];
            if (isSymbolWinner(winningCombination, CellState.O) || isSymbolWinner(winningCombinations[i], CellState.X))
            {
                System.out.println("Congradulations you have won");
                return true;
            }
        }
        return false;
    }

    private Boolean isSymbolWinner(Integer[] winningCombination, CellState symbol) {
        Boolean isWon = getCells().get(winningCombination[0]).cellState == symbol
                && getCells().get(winningCombination[1]).cellState == symbol
                && getCells().get(winningCombination[2]).cellState == symbol;
        return isWon;

    }

    private Boolean isDraw() {
        Boolean isDraw = !IntStream.rangeClosed(0, getCells().size() - 1)
                .anyMatch(i -> getCells().get(i).getCellState() == CellState.NOT_TAKEN);
        if (isDraw){
            System.out.println("Draw... pathetic");
        }
        return isDraw;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
