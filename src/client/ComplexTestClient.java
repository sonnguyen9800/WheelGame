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
 * 
 */
public class ComplexTestClient
{
   private static final Logger logger = Logger.getLogger(ComplexTestClient.class.getName());
   private static final Integer MAX_TURN_PLAY = 2;

   public static void main(String[] args)
   {
      final GameEngine gameEngine = new GameEngineImpl();

      // call method in Validator.jar to test *structural* correctness
      // just passing this does not mean it actually works .. you need to test yourself!
      // pass false if you want to show minimal logging (pass/fail) .. (i.e. ONLY once it passes)
      Validator.validate(true);

      // create some test players
      Player[] players = new Player[] { new SimplePlayer("1", "Adam", 1000),
         new SimplePlayer("2", "Eve", 1000),
              new SimplePlayer("3", "Lilith", 1000) };

      // add logging callback
      gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());


      //ADD PLAYER TO THE Game Engine
      for (Player player : players){
         gameEngine.addPlayer(player);
      }

      int turn = 0;

      while (turn < MAX_TURN_PLAY){
         turnBet(players, gameEngine, turn );
         turn++;
      }


   }

   private static void gameResult(Player[] players , int turn_number){
      logger.log(Level.INFO, "=========END TURN: " + turn_number + " ===============" );

      for (Player player : players){
         logger.log(Level.INFO, " Player Result: " + player.toString());
      }
   }

   private static void turnBet(Player[] players, GameEngine gameEngine, int turn_number){
      logger.log(Level.INFO, "========== TURN NUMBER: " + turn_number + " ==========");

      for (Player player : players) {
         gameEngine.placeBet(player, playersBet(player), playersBettype());
         logger.log(Level.INFO, "Player " + player.toString());
      }

      gameSpin(gameEngine);
      gameResult(players, turn_number);

   }

   private static void gameSpin(GameEngine gameEngine){
      logger.log(Level.INFO, "========= SPIN RESULT :============== ");

      gameEngine.spin(1, 100, 5);
   }

   //Randomize Select a bet point for player
   private static int playersBet(Player player){
      Random random = new Random();
      return random.nextInt(player.getPoints());
   }

   private static BetType playersBettype(){

      Random random = new Random();
      int val = random.nextInt(10);

      if (val < 4){
         return BetType.RED;
      } else if (val <= 8){
         return BetType.BLACK;
      } else if (val == 9){
         return BetType.GREEN0;
      } else {
         return BetType.GREEN00;
      }


   }

   // private helper method to log wheel slots
   private static void logWheel(Collection<Slot> wheel)
   {
      logger.log(Level.INFO, "LOGGING WHEEL DATA CREATED BY GameEngineImpl");
      for (Slot slot : wheel)
         logger.log(Level.INFO, slot.toString());
      logger.log(Level.INFO, "END WHEEL LOG\n");
   }
}
