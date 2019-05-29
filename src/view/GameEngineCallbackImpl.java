package view;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.FINE;
import static java.util.logging.Level.INFO;

/**
 * Skeleton/Partial example implementation of GameEngineCallback showing Java logging behaviour
 *
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
    private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

    public GameEngineCallbackImpl() {
        // FINE shows wheel spinning output, INFO only shows result
        logger.setLevel(Level.INFO);
    }

    @Override
    public void nextSlot(Slot slot, GameEngine engine) {
        // intermediate results logged at Level.FINE
        logger.log(INFO, "Next Slot " + slot.toString());

    }

    @Override
    public void result(Slot result, GameEngine engine) {
        // final results logged at Level.INFO
        logger.log(INFO, "RESULT="+result.toString() + "\n");
        logger.log(INFO, "FINAL PLAYER POINT BALANCES");

        String mess = "\n";
        for (Player player : engine.getAllPlayers()){
            mess = mess.concat(player.toString());
            mess = mess.concat("\n");
        }
        logger.log(INFO, "" + mess);
//Player: id=1, name=Come In Spinner, bet=100, betType=RED, points=1100
//Player: id=2, name=The Loser, bet=100, betType=BLACK, points=650
//Player: id=3, name=The Dabbler, bet=100, betType=ZEROS, points=400
    }
}
