package com.Timos.Games.GameComponents;

import org.springframework.stereotype.Component;

@Component
public interface IGame {

    public Boolean isInputValidForGame(Integer input);

    public Boolean isGameFinished();
}
