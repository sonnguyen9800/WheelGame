package view.Test;

import model.GameEngineImpl;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

import javax.swing.*;

public class MVCtest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameEngineImpl gameEngine = (GameEngineImpl) GameEngineImpl.getSingletonInstance();
                gameEngine.addGameEngineCallback(GameEngineCallbackGUI.getSingletonInstance());
                gameEngine.addGameEngineCallback(GameEngineCallbackImpl.getSingletonInstance());
            }
        });
    }
}
