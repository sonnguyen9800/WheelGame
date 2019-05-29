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

    /**
     * called as the wheel spins<br>
     * use this to update GUI or log to console
     *
     * @param slot   - the next slot that the rolling ball entered
     * @param engine - a convenience reference to the engine so the receiver can call methods if necessary
     * @see model.interfaces.GameEngine
     */

    @Override
    public void nextSlot(Slot slot, GameEngine engine) {
        // intermediate results logged at Level.FINE
        logger.log(INFO, "Next Slot " + slot.toString());

    }
    /**
     * called when the wheel has stopped spinning<br>
     * this is a convenient place to call {@link GameEngine#calculateResult(Slot winningSlot)}<br>
     * and {@link Player#resetBet()}
     *
     * @param result- the slot that the ball landed in
     * @param engine      - a convenience reference to the engine so the receiver can call methods if necessary
     * @see model.interfaces.GameEngine
     */
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
