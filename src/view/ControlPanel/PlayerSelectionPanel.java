package view.ControlPanel;

import controller.SpinPanelController;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This Panel provides the Combo Box, that help users to choose which player is edited
 *
 * This is inside ControlPanel
 * @see ControlPanel
 * @see GameEngine
 * @see PlayerEditorPanel
 * @see JComboBox
 */
public class PlayerSelectionPanel extends JPanel {
    private JComboBox<String> comboPlayers = new JComboBox<>();
    private GameEngineCallbackGUI gameEngineCallbackGUI ;
    /**
     * Constructor take GameEngineCallback as parameter
     *
     * @see GameEngineCallbackGUI
     *
     */
    public PlayerSelectionPanel(GameEngineCallbackGUI gameEngineCallbackGUI){
        super();
        this.gameEngineCallbackGUI = gameEngineCallbackGUI;
        JLabel jLabel = new JLabel("Select a Player");
        add(jLabel);

        updateComboPlayers();
    }

    /**
     * This method updates the ComboBox
     * E.g when new player shows up, this combo box will be updated
     */

    public void updateComboPlayers(){
        comboPlayers.removeAllItems();
        for (Player player : this.gameEngineCallbackGUI.getPlayers()){
            comboPlayers.addItem("ID "+ player.getPlayerId()+": " + player.getPlayerName());
        }
        comboPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int item = comboPlayers.getSelectedIndex();
                setSelectedPlayer(item);
            }
        });
        add(comboPlayers);

    }
    /**
     * This method provide Player parameter for the PlayerEditorPanel
     *
     * @param index
     * @see PlayerEditorPanel
     */
    private void setSelectedPlayer(int index){
        if ( 0 <= index && index <= this.gameEngineCallbackGUI.getPlayers().size()){
            this.gameEngineCallbackGUI.setSelectedPlayer(this.gameEngineCallbackGUI.getPlayers().get(index));
        }
    }
}
