package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.GameRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameRunnerTest {

    @Autowired GameRunner gameRunner;

    @Test
    void shouldRunGameRunner(){
        gameRunner.run();
    }
}
