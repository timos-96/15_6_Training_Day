package com.Timos.Games.TicTacToeGame;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.generate;

@Component
public class Board {

    private static final Integer GRID_SIZE = 9;
    private static final Integer TOP_LEFT = 0;
    private static final Integer TOP_CENTER = 1;
    private static final Integer TOP_RIGHT = 2;
    private static final Integer MIDDLE_LEFT = 3;
    private static final Integer MIDDLE_CENTER = 4;
    private static final Integer MIDDLE_RIGHT = 5;
    private static final Integer BOTTOM_LEFT = 6;
    private static final Integer BOTTOM_CENTER = 7;
    private static final Integer BOTTOM_RIGHT = 8;

    private List<Cell> cells;
    private final Integer[][] winningCombinations = {
        {TOP_LEFT, TOP_CENTER, TOP_RIGHT},
        {MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT},
        {BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT},
        {TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT},
        {TOP_CENTER, MIDDLE_CENTER, BOTTOM_CENTER},
        {TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT},
        {TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT},
        {TOP_RIGHT, MIDDLE_CENTER, BOTTOM_LEFT}
    };

    public Board() {
        cells = generate(Cell::new).limit(GRID_SIZE).collect(Collectors.toList());
    }

    public Boolean isInputValid(Integer input) {
        if (input < 0 || input >= cells.size()) {
            System.out.println("Please re-enter move");
            return false;
        } else {
            return cells.get(input).cellState == CellState.NOT_TAKEN;
        }
    }

    public void placeMove(Integer input, CellState symbol) {
        getCells().get(input).setCellState(symbol);
        System.out.println("Move placed on cell " + input);
    }

    public void showBoard() {
        getCells().forEach(cell -> System.out.println(cell.getCellState()));
    }

    public Boolean isFinished() {
        return (isDraw() || isWin());
    }

    private Boolean isWin() {
        Boolean isWin = Arrays.stream(winningCombinations).anyMatch(this::isWin);
        if (isWin) System.out.println("Congratulations you have won");
        return isWin;
    }

    private boolean isWin(Integer[] winningCombination) {
        return Stream.of(CellState.X, CellState.O)
            .anyMatch(cellState -> isSymbolWinner(winningCombination, cellState));
    }

    private Boolean isSymbolWinner(Integer[] winningCombination, CellState symbol) {
        return getCells().get(winningCombination[0]).cellState == symbol
            && getCells().get(winningCombination[1]).cellState == symbol
            && getCells().get(winningCombination[2]).cellState == symbol;

    }

    private Boolean isDraw() {
        Boolean isDraw = IntStream.rangeClosed(0, getCells().size() - 1)
            .noneMatch(i -> getCells().get(i).getCellState() == CellState.NOT_TAKEN);
        if (isDraw) {
            System.out.println("Draw... pathetic");
        }
        return isDraw;
    }

    public List<Cell> getCells() {
        return cells;
    }
}
