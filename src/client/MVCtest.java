package client;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

import javax.swing.*;
/**
 * MAIN RUNNER
 *
 * Run this file to play the game
 */
public class MVCtest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameEngine gameEngine = new GameEngineImpl();

                GameEngineCallback gameEngineCallbackImp = new GameEngineCallbackImpl();
                gameEngine.addGameEngineCallback(gameEngineCallbackImp);

                try{
                    GameEngineCallback gameEngineCallbackGUI = new GameEngineCallbackGUI(gameEngine);
                    gameEngine.addGameEngineCallback(gameEngineCallbackGUI);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });
    }
}
