package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.TicTacToeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicTacToeGameTest {

    TicTacToeGame ticTacToeGame = new TicTacToeGame();

    @Test
    void shouldCreateGame() {
        Assertions.assertNotNull(ticTacToeGame);
    }
}
