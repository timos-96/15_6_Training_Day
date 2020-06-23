package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.Board;
import com.Timos.Games.TicTacToeGame.CellState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    Board board = new Board();

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    void shouldCreateBoard() {
        assertFalse(board == null);
    }

    @Test
    void shouldcreateAListOf9EmptyCells() {
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

    @Test
    void shouldAllowMoveOnEmptyCell() {
        assertTrue(board.isInputValid(1));
    }

    @Test
    void shouldNotAllowMoveOnOccupiedCell() {
        board.getCells().get(1).setCellState(CellState.O);
        assertFalse(board.isInputValid(1));
    }

    @Test
    void shouldNotAllowMoveSmallerThanBoardSize() {
        assertFalse(board.isInputValid(-1));
    }

    @Test
    void shouldNotAllowMoveLargerThanBoardSize() {
        assertFalse(board.isInputValid(9));
    }

    @Test
    void shouldFinishWhenNoMovesLeft() {
        for (int i = 0; i < board.getCells().size(); i++) {
            board.getCells().get(i).setCellState(CellState.O);
        }
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenVictoryConditionIsMetForO() {
        for (int i = 0; i < 3; i++) {
            board.getCells().get(i).setCellState(CellState.O);
        }
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenHorizontalVictoryConditionIsMetForX() {
        for (int i = 3; i < 6; i++) {
            board.getCells().get(i).setCellState(CellState.X);
        }
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenHorizontalVictoryConditionIsMetForO2() {
        for (int i = 6; i < 9; i++) {
            board.getCells().get(i).setCellState(CellState.X);
        }
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenVerticalVictoryConditionIsMetForX() {
        board.getCells().get(0).setCellState(CellState.X);
        board.getCells().get(3).setCellState(CellState.X);
        board.getCells().get(6).setCellState(CellState.X);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenVerticalVictoryConditionIsMetForO() {
        board.getCells().get(1).setCellState(CellState.O);
        board.getCells().get(4).setCellState(CellState.O);
        board.getCells().get(7).setCellState(CellState.O);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenVerticalVictoryConditionIsMetForX2() {
        board.getCells().get(2).setCellState(CellState.X);
        board.getCells().get(5).setCellState(CellState.X);
        board.getCells().get(8).setCellState(CellState.X);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenDiagonalVictoryConditionIsMetForO() {
        board.getCells().get(0).setCellState(CellState.O);
        board.getCells().get(4).setCellState(CellState.O);
        board.getCells().get(8).setCellState(CellState.O);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenDiagonalVictoryConditionIsMetForX() {
        board.getCells().get(2).setCellState(CellState.X);
        board.getCells().get(4).setCellState(CellState.X);
        board.getCells().get(6).setCellState(CellState.X);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldPlaceMove() {
        board.placeMove(1, CellState.O);
        assertEquals(board.getCells().get(1).getCellState(), CellState.O);
    }

    @Test
    void shouldNotPlaceMoveOnOtherCells() {
        board.placeMove(2, CellState.O);
        assertNotEquals(board.getCells().get(1).getCellState(), CellState.O);
    }
}
