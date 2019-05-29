package controller;

import model.GameEngineImpl;
import model.interfaces.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SpinPanelController implements ActionListener {
    private GameEngine gameEngine;
    public SpinPanelController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("LOL");
        gameEngine.spin(500,2000,200);

    }
}
