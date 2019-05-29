package client;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;

public class TestFunctions {
    public static void main(String[] args) {
        Player player = new SimplePlayer("1", "Hello", 1000);
        System.out.println(player.toString());
        GameEngine gameEngine = new GameEngineImpl();
        gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
        gameEngine.spin(1,100,4);
    }
}
