package com.Timos.Games;

import com.Timos.Games.TicTacToeGame.TicTacToeGameRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);

		TicTacToeGameRunner gameRunner = new TicTacToeGameRunner();
		gameRunner.runTicTacToe();
	}

}
