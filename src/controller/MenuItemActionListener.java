package controller;

import view.Dialog.PlayerNewDialog;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This action Listener is used for the MenuItem, used to create new Player
 *
 * @see view.Menu.WheelMenuBar
 * @see java.awt.MenuItem
 * @see view.Menu.MenuItemPlayer
 */

public class MenuItemActionListener implements ActionListener {
    private GameEngineCallbackGUI gameEngineCallbackGUI;

    public MenuItemActionListener(JFrame jFrame, GameEngineCallbackGUI gameEngineCallbackGUI) {
        super();
        this.gameEngineCallbackGUI = gameEngineCallbackGUI;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        PlayerNewDialog playerNewDialog = new PlayerNewDialog(gameEngineCallbackGUI);

    }
}
