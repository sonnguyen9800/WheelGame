package view.ControlPanel;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ControlPanel extends JPanel {
    private Player selectedPlayer;
    private PlayerEditorPanel playerEditorPanel = new PlayerEditorPanel();
    private PlayerSelectionPanel playerSelectionPanel;
    private SpinPanel spinPanel = new SpinPanel();

    public ControlPanel(GameEngineCallbackGUI gameEngineCallbackGUI){
        String title = "Controller";
        Border border = BorderFactory.createTitledBorder(title);
        playerSelectionPanel = new PlayerSelectionPanel(gameEngineCallbackGUI);

        this.setBorder(border);
        this.setLayout(new BorderLayout());
        this.add(playerSelectionPanel, BorderLayout.NORTH);
        this.add(playerEditorPanel, BorderLayout.CENTER);
        this.add(spinPanel, BorderLayout.SOUTH);

    }
    public PlayerEditorPanel getPlayerEditorPanel(){
        return this.playerEditorPanel;
    }
    public PlayerSelectionPanel getPlayerSelectionPanel(){
        return this.playerSelectionPanel;
    }

}
