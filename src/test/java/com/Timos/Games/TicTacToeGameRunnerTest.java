package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.TicTacToeGameRunner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicTacToeGameRunnerTest {

    @Autowired
    TicTacToeGameRunner gameRunner;

//    @Test
//    void shouldRunTicTacToeGameRunner(){
//        gameRunner.runTicTacToe();
//    }
}