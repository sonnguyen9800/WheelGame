package controller;

import view.Dialog.PlayerNewDialog;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuItemActionListener implements ActionListener {
    JFrame frame;
    PlayerNewDialog playerNewDialog;

    public MenuItemActionListener(JFrame jFrame) {
        super();
        this.frame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        playerNewDialog = new PlayerNewDialog();

    }
}
