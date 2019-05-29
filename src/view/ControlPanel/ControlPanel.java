package view.ControlPanel;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ControlPanel extends JPanel {
    private PlayerEditorPanel playerEditorPanel = new PlayerEditorPanel();
    private PlayerSelectionPanel playerSelectionPanel;

    public ControlPanel(GameEngineCallbackGUI gameEngineCallbackGUI){
        String title = "Controller";
        Border border = BorderFactory.createTitledBorder(title);
        playerSelectionPanel = new PlayerSelectionPanel(gameEngineCallbackGUI);

        this.setBorder(border);
        this.setLayout(new BorderLayout());
        this.add(playerSelectionPanel, BorderLayout.NORTH);
        this.add(playerEditorPanel, BorderLayout.CENTER);
        SpinPanel spinPanel = new SpinPanel();
        this.add(spinPanel, BorderLayout.SOUTH);

    }
    public PlayerEditorPanel getPlayerEditorPanel(){
        return this.playerEditorPanel;
    }
    public PlayerSelectionPanel getPlayerSelectionPanel(){
        return this.playerSelectionPanel;
    }

}
