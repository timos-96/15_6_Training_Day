package com.Timos.Games.TicTacToeGame;

import com.Timos.Games.GameComponents.IInputRetriever;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Scanner;

@Component
public class ConsoleInputRetriever implements IInputRetriever {

    public Integer retrieveInput(InputStream in) {
        System.out.println("Please place move: ");
        Scanner scanner = new Scanner(in);
        return scanner.nextInt();
    }
}
