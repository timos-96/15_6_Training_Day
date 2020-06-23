package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.ConsoleInputRetriever;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

public class ConsoleInputRetrieverTest {

    private ConsoleInputRetriever retriever = new ConsoleInputRetriever();

    @Test
    void shouldReturnUserInputWhenPresent() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Assertions.assertEquals(1, retriever.retrieveInput(in).orElse(null));
    }

    @Test
    void shouldReturnEmptyWhenNoInput() {
        InputStream in = new ByteArrayInputStream("".getBytes());
        Assertions.assertEquals(Optional.empty(), retriever.retrieveInput(in));
    }

    @Test
    void shouldReturnEmptyWhenInvalidInput() {
        InputStream in = new ByteArrayInputStream("invalid".getBytes());
        Assertions.assertEquals(Optional.empty(), retriever.retrieveInput(in));
    }
}
