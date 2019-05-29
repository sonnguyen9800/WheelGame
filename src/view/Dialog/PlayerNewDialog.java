package view.Dialog;

import model.SimplePlayer;
import view.GameEngineCallbackGUI;

import javax.swing.*;

public class PlayerNewDialog extends JDialog {

    public PlayerNewDialog(){
        JTextField playerID = new JTextField();
        JTextField playerName = new JTextField();
        JTextField playerIniPoint = new JTextField();

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Player ID"),
                playerID,
                new JLabel("Player Name"),
                playerName,
                new JLabel("Player InititalPoint"),
                playerIniPoint

        };
        int result = JOptionPane.showConfirmDialog(null, inputs, "My new Player", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try{
                SimplePlayer simplePlayer = new SimplePlayer(playerID.getText(), playerName.getText(), Integer.parseInt(playerIniPoint.getText()));
                System.out.println(simplePlayer.toString());
                GameEngineCallbackGUI gameEngineCallbackGUI = (GameEngineCallbackGUI) GameEngineCallbackGUI.getSingletonInstance();
                gameEngineCallbackGUI.createNewPlayer(simplePlayer);
            }catch (Exception e){
                System.out.println("LOL :" + e);
            }

        }
    }
}
