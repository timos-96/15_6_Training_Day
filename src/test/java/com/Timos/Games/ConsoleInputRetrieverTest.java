package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.ConsoleInputRetriever;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@SpringBootTest
public class ConsoleInputRetrieverTest {


    @Autowired ConsoleInputRetriever retriever;

    @Test
    void shouldReturnUserInput(){

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertTrue(retriever.retrieveInput(in) == 1);
    }
}
