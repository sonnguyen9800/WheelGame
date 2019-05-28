package client;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import validate.Validator;
import view.GameEngineCallbackImpl;

import java.util.Collection;
import java.util.Random;
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
public class ComplexTestClient {
    private static final Logger logger = Logger.getLogger(ComplexTestClient.class.getName());
    private static final Integer MAX_TURN_PLAY = 2;
    private static final Integer INI_DELAY = 1;
    private static final Integer FIN_DELAY = 100;

    private static final Integer RANDOM_MAX = 100;
    private static final Integer RANDOM_MIN = 10;


    public static void main(String[] args) {
        final GameEngine gameEngine = GameEngineImpl.getSingletonInstance();

        // call method in Validator.jar to test *structural* correctness
        // just passing this does not mean it actually works .. you need to test yourself!
        // pass false if you want to show minimal logging (pass/fail) .. (i.e. ONLY once it passes)
        Validator.validate(true);

        // create some test players
        Player[] players = new Player[]{new SimplePlayer("1", "Adam", 1000),
                new SimplePlayer("2", "Eve", 1000),
                new SimplePlayer("3", "Lilith", 1000)};

        // add logging callback
        gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

        //Print the Wheel:
        logWheel(gameEngine.getWheelSlots());

        //ADD PLAYER TO THE Game Engine
        for (Player player : players) {
            gameEngine.addPlayer(player);
        }

        int turn = 0;

        while (turn < MAX_TURN_PLAY) {
            turnBet(players, gameEngine, turn);
            turn++;
        }


    }

    private static void gameResult(Player[] players, int turn_number) {
        logger.log(Level.INFO, "=========END TURN: " + turn_number + " ===============");

        for (Player player : players) {
            logger.log(Level.INFO, " Player Result: " + player.toString());
        }
    }

    /*
    PLAYERS BEGIN TO BET
     */
    private static void turnBet(Player[] players, GameEngine gameEngine, int turn_number) {
        logger.log(Level.INFO, "========== TURN NUMBER: " + turn_number + " ==========");

        for (Player player : players) {
            gameEngine.placeBet(player, playersBet(player), playersBettype());
            logger.log(Level.INFO, "Player " + player.toString());
        }

        gameSpin(gameEngine, randomDelayIncre());
        gameResult(players, turn_number);

    }

    /*
    SPIN THE WHEEL -
    SET THE INCREMENT OF THE WHEEL SPIN THROUGH DELAY PARAMETER; SEE INI_DELAY, FIN_DELAY stastic inteter
     */
    private static void gameSpin(GameEngine gameEngine, int delay_incre) {
        logger.log(Level.INFO, "========= SPIN RESULT :============== ");

        gameEngine.spin(INI_DELAY, FIN_DELAY, delay_incre);
    }

    //Randomize Select a bet point for player
    private static int playersBet(Player player) {
        Random random = new Random();
        return random.nextInt(player.getPoints());
    }

    //Random Select a Bettype for each player
    //The chance thay choose RED:BLACK:GREEN = 4 : 4 : 2 = 2 : 2 : 1
    private static BetType playersBettype() {

        Random random = new Random();
        int val = random.nextInt(10);

        if (val < 4) {
            return BetType.RED;
        } else if (val <= 8) {
            return BetType.BLACK;
        } else if (val == 9) {
            return BetType.ZEROS;
        } else {
            return BetType.ZEROS;
        }


    }

    //Random generator to select the Delay Increment
    private static int randomDelayIncre() {
        double val = (double) (RANDOM_MAX - RANDOM_MIN + 1) / 100 * (new Random().nextInt(RANDOM_MAX));
        return (int) Math.round(val);
    }

    // private helper method to log wheel slots
    private static void logWheel(Collection<Slot> wheel) {
        logger.log(Level.INFO, "LOGGING WHEEL DATA CREATED BY GameEngineImpl");
        for (Slot slot : wheel)
            logger.log(Level.INFO, slot.toString());
        logger.log(Level.INFO, "END WHEEL LOG\n");
    }
}
