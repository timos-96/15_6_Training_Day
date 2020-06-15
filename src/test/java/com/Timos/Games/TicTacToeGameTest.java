package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.TicTacToeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicTacToeGameTest {

    @Autowired TicTacToeGame ticTacToeGame;

    @Test
    void shouldCreateGame(){
        Assertions.assertFalse(ticTacToeGame == null);
    }
}
