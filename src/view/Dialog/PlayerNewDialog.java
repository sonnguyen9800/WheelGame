package view.Dialog;

import model.SimplePlayer;
import view.GameEngineCallbackGUI;

import javax.swing.*;

public class PlayerNewDialog extends JDialog {
    private GameEngineCallbackGUI gameEngineCallbackGUI = (GameEngineCallbackGUI) GameEngineCallbackGUI.getSingletonInstance();

    public PlayerNewDialog(){
        JTextField playerID = new JTextField();
        JTextField playerName = new JTextField();
        JTextField playerIniPoint = new JTextField();

        if (gameEngineCallbackGUI == null){
            playerID.setText("NUL");
        }else{
            playerID.setText("NOT NULL");
        }

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Player ID"),
                playerID,
                new JLabel("Player Name"),
                playerName,
                new JLabel("Player InititalPoint"),
                playerIniPoint

        };
        int result = JOptionPane.showConfirmDialog(null, inputs, "My new Player", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try{
                SimplePlayer simplePlayer = new SimplePlayer(playerID.getText(),
                        playerName.getText(),
                        Integer.parseInt(playerIniPoint.getText()));
                System.out.println(simplePlayer.toString());
                gameEngineCallbackGUI.createNewPlayer(simplePlayer);
            }catch (Exception e){
                System.out.println(e);
            }

        } else {
//            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }
}
