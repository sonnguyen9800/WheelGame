package view.ControlPanel;

import controller.SpinPanelController;
import model.interfaces.GameEngine;

import javax.swing.*;
import java.awt.*;

/**
 * This Panel provides the Spin Button, used to spin the whale and trigger
 * events
 * This is inside ControlPanel
 *
 * @see ControlPanel
 * @see GameEngine
 * @see SpinPanelController
 */

public class SpinPanel extends JPanel {
    private GameEngine gameEngine;

    public SpinPanel(GameEngine gameEngine) {
        setSize(300, 180);
        JButton spin = new JButton();

        this.gameEngine = gameEngine;
        spin.setText("SPIN THE WHEEL");
        spin.setPreferredSize(new Dimension(200, 75));
        spin.addActionListener(new SpinPanelController(gameEngine));

        add(spin);
    }
}
