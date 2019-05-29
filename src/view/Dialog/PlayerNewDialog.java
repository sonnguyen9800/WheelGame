package view.Dialog;

import model.SimplePlayer;
import view.GameEngineCallbackGUI;

import javax.swing.*;

/**
 * This JDialog takes input from users and create new Player
 *
 * @see model.interfaces.Player
 * @see controller.MenuItemActionListener
 * @see view.Menu.MenuItemPlayer
 */
public class PlayerNewDialog extends JDialog {
    private GameEngineCallbackGUI gameEngineCallbackGUI;

    public PlayerNewDialog(GameEngineCallbackGUI gameEngineCallbackGUI) {
        JTextField playerID = new JTextField();
        JTextField playerName = new JTextField();
        JTextField playerIniPoint = new JTextField();

        this.gameEngineCallbackGUI = gameEngineCallbackGUI;

        final JComponent[] inputs = new JComponent[]{
                new JLabel("Player ID"),
                playerID,
                new JLabel("Player Name"),
                playerName,
                new JLabel("Player InititalPoint"),
                playerIniPoint

        };
        int result = JOptionPane.showConfirmDialog(null, inputs, "My new Player", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                SimplePlayer simplePlayer = new SimplePlayer(playerID.getText(), playerName.getText(), Integer.parseInt(playerIniPoint.getText()));
                gameEngineCallbackGUI.createNewPlayer(simplePlayer);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
