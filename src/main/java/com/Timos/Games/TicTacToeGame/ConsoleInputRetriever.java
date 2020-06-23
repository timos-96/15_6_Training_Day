package com.Timos.Games.TicTacToeGame;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleInputRetriever {

    public Optional<Integer> retrieveInput(InputStream in) {
        System.out.println("Please place move: ");
        Scanner scanner = new Scanner(in);
        try {
            return Optional.of(scanner.nextInt());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
