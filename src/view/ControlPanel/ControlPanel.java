package view.ControlPanel;

import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Control Panel includes 3 part
 *
 * @see PlayerSelectionPanel
 * @see PlayerEditorPanel
 * @see SpinPanel
 */
public class ControlPanel extends JPanel {
    private PlayerEditorPanel playerEditorPanel;
    private PlayerSelectionPanel playerSelectionPanel;
    private GameEngine gameEngine;

    /**
     * Main Constructor
     */
    public ControlPanel(GameEngineCallbackGUI gameEngineCallbackGUI, GameEngine gameEngine) {
        String title = "Controller";
        Border border = BorderFactory.createTitledBorder(title);

        playerSelectionPanel = new PlayerSelectionPanel(gameEngineCallbackGUI);
        playerEditorPanel = new PlayerEditorPanel(gameEngineCallbackGUI, gameEngine);

        this.gameEngine = gameEngine;
        this.setBorder(border);
        this.setLayout(new BorderLayout());
        this.add(playerSelectionPanel, BorderLayout.NORTH);
        this.add(playerEditorPanel, BorderLayout.CENTER);

        SpinPanel spinPanel = new SpinPanel(gameEngine);
        this.add(spinPanel, BorderLayout.SOUTH);

    }

    public PlayerEditorPanel getPlayerEditorPanel() {
        return this.playerEditorPanel;
    }

    public PlayerSelectionPanel getPlayerSelectionPanel() {
        return this.playerSelectionPanel;
    }

}
