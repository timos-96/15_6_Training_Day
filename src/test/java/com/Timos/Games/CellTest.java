package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.Cell;
import com.Timos.Games.TicTacToeGame.CellState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    void constructorShouldCreateEmptyCell(){
        Cell cell = new Cell();
        Assertions.assertSame(cell.getCellState(), CellState.NOT_TAKEN);
    }
}
