package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.Board;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.Timos.Games.TicTacToeGame.CellState;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest {

    @Autowired
    Board board;

    @Test
    void shouldCreateBoard(){
        assertFalse(board == null);
    }

    @Test
    void shouldcreateAListOf9EmptyCells(){
        assertAll("Should return 9 empty cells",
                () -> assertTrue(board.getCells().size() == 9),
                () -> assertTrue(board.getCells().get(0).getCellState() == CellState.NOT_TAKEN),
                () -> assertTrue(board.getCells().get(1).getCellState() == CellState.NOT_TAKEN),
                () -> assertTrue(board.getCells().get(2).getCellState() == CellState.NOT_TAKEN),
                () -> assertTrue(board.getCells().get(3).getCellState() == CellState.NOT_TAKEN),
                () -> assertTrue(board.getCells().get(4).getCellState() == CellState.NOT_TAKEN),
                () -> assertTrue(board.getCells().get(5).getCellState() == CellState.NOT_TAKEN),
                () -> assertTrue(board.getCells().get(6).getCellState() == CellState.NOT_TAKEN),
                () -> assertTrue(board.getCells().get(7).getCellState() == CellState.NOT_TAKEN),
                () -> assertTrue(board.getCells().get(8).getCellState() == CellState.NOT_TAKEN));
    }
}
