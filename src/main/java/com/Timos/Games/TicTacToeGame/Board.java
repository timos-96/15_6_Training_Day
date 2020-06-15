package com.Timos.Games.TicTacToeGame;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class Board {

    private List<Cell> cells;
    private final Integer boardSize = 9;

    public Board(){
       cells = new ArrayList<Cell>();
       IntStream.rangeClosed(1, boardSize).forEach(i -> cells.add(new Cell()));
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
