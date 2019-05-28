package view.ControlPanel;

import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;

public class PlayerSelectionPanel extends JPanel {
    JComboBox<String> comboLanguage = new JComboBox<>();
    private GameEngineCallbackGUI gameEngineCallbackGUI ;

    public PlayerSelectionPanel(GameEngineCallbackGUI gameEngineCallbackGUI){
        super();
        this.gameEngineCallbackGUI = gameEngineCallbackGUI;
        JLabel jLabel = new JLabel("Select a Player");
        add(jLabel);


        add(comboLanguage);
    }
}
