package client;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import validate.Validator;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre> Simple console client for Further Programming assignment 1, 2019
 * <b>NOTE:</b> This code will not compile until you have implemented code for the supplied interfaces!
 *
 * You must be able to compile your code WITHOUT modifying this class.
 * Additional testing should be done by copying and adding to this class while ensuring this class still works.
 *
 * The provided Validator.jar will check if your code adheres to the specified interfaces!</pre>
 *
 * @author Caspar Ryan
 */
public class SimpleTestClient2 {
    private static final Logger logger = Logger.getLogger(SimpleTestClient2.class.getName());
    private static List<Player> players = new ArrayList<>();
    public static void main(String[] args) {
        final GameEngine gameEngine = GameEngineImpl.getSingletonInstance();

        gameEngine.addGameEngineCallback(GameEngineCallbackImpl.getSingletonInstance());
        gameEngine.addGameEngineCallback(GameEngineCallbackGUI.getSingletonInstance());
        gameEngine.spin(1, 500, 50);
    }

}
