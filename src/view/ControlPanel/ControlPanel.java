package view.ControlPanel;
import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ControlPanel extends JPanel {
    private PlayerEditorPanel playerEditorPanel;
    private PlayerSelectionPanel playerSelectionPanel;
    private GameEngine gameEngine;
    public ControlPanel(GameEngineCallbackGUI gameEngineCallbackGUI, GameEngine gameEngine){
        String title = "Controller";
        Border border = BorderFactory.createTitledBorder(title);

        playerSelectionPanel = new PlayerSelectionPanel(gameEngineCallbackGUI);
        playerEditorPanel= new PlayerEditorPanel(gameEngineCallbackGUI);

        this.gameEngine = gameEngine;
        this.setBorder(border);
        this.setLayout(new BorderLayout());
        this.add(playerSelectionPanel, BorderLayout.NORTH);
        this.add(playerEditorPanel, BorderLayout.CENTER);

        SpinPanel spinPanel = new SpinPanel(gameEngine);
        this.add(spinPanel, BorderLayout.SOUTH);

    }
    public PlayerEditorPanel getPlayerEditorPanel(){
        return this.playerEditorPanel;
    }
    public PlayerSelectionPanel getPlayerSelectionPanel(){
        return this.playerSelectionPanel;
    }

}
