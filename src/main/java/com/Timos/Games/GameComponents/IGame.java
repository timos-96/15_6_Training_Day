package com.Timos.Games.GameComponents;

import org.springframework.stereotype.Component;

@Component
public interface IGame {

    Boolean isInputValidForGame(Integer input);

    Boolean isGameFinished();

    void placeMoveOnBoard(Integer input);

    void showGame();
}
