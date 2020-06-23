package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.ConsoleInputRetriever;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleInputRetrieverTest {

    private ConsoleInputRetriever retriever = new ConsoleInputRetriever();

    @Test
    void shouldReturnUserInput() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Assertions.assertEquals(1, retriever.retrieveInput(in));
    }
}
