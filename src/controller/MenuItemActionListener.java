package controller;

import view.Dialog.PlayerNewDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemActionListener implements ActionListener {
    JFrame frame;
    PlayerNewDialog playerNewDialog;
    public MenuItemActionListener(JFrame jFrame) {
        super();
        this.frame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //JOptionPane.showMessageDialog(frame, actionEvent.getActionCommand());
        playerNewDialog = new PlayerNewDialog();

    }
}
