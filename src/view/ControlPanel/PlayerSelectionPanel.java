package view.ControlPanel;

import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSelectionPanel extends JPanel {
    JComboBox<String> comboPlayers = new JComboBox<>();
    private GameEngineCallbackGUI gameEngineCallbackGUI ;


    public PlayerSelectionPanel(GameEngineCallbackGUI gameEngineCallbackGUI){
        super();
        this.gameEngineCallbackGUI = gameEngineCallbackGUI;
        JLabel jLabel = new JLabel("Select a Player");
        add(jLabel);

        updateComboPlayers();
    }

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
    public void setSelectedPlayer(int index){
        if ( 0 <= index && index <= this.gameEngineCallbackGUI.getPlayers().size()){
            this.gameEngineCallbackGUI.setSelectedPlayer(this.gameEngineCallbackGUI.getPlayers().get(index));
        }
    }
}
