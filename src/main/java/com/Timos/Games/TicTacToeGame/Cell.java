package com.Timos.Games.TicTacToeGame;

public class Cell {

    CellState cellState;

    public Cell(){
        cellState = CellState.NOT_TAKEN;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
