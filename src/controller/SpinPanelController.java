package controller;

import model.GameEngineImpl;
import model.interfaces.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This ActionListenr is used for the SpinPanel, SpinButton
 * take GameEngine as parameter for construction
 * @see GameEngine
 * @see view.ControlPanel.SpinPanel
 */

public class SpinPanelController implements ActionListener {
    private GameEngine gameEngine;
    public SpinPanelController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gameEngine.spin(1,200,4);
    }
}
