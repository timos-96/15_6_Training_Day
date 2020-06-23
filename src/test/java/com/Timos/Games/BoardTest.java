package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.Board;
import com.Timos.Games.TicTacToeGame.Cell;
import com.Timos.Games.TicTacToeGame.CellState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    Board board = new Board();

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    void shouldCreateBoard() {
        assertNotNull(board);
    }

    @Test
    void shouldcreateAListOf9EmptyCells() {
        assertAll("Should return 9 empty cells",
            () -> assertEquals(9, board.getCells().size()),
            () -> assertEquals(
                board.getCells().stream().map(Cell::getCellState).collect(Collectors.toUnmodifiableSet()),
                Set.of(CellState.NOT_TAKEN)
            )
        );
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
        setCells(List.of(0, 3, 6), CellState.X);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenVerticalVictoryConditionIsMetForO() {
        setCells(List.of(1, 4, 7), CellState.O);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenVerticalVictoryConditionIsMetForX2() {
        setCells(List.of(2, 5, 8), CellState.X);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenDiagonalVictoryConditionIsMetForO() {
        setCells(List.of(0, 4, 8), CellState.O);
        assertTrue(board.isFinished());
    }

    @Test
    void shouldFinishWhenDiagonalVictoryConditionIsMetForX() {
        setCells(List.of(2, 4, 6), CellState.X);
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

    private void setCells(List<Integer> cellIndices, CellState cellState) {
        cellIndices.forEach(
            cellIndex -> board.getCells().get(cellIndex).setCellState(cellState)
        );
    }
}
