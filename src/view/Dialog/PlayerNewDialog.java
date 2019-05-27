package view.Dialog;

import model.SimplePlayer;

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
        int result = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            SimplePlayer simplePlayer = new SimplePlayer(playerID.getText(),
                    playerName.getText(),
                    Integer.parseInt(playerIniPoint.getText()));
            System.out.println(simplePlayer.toString());
        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }
}
