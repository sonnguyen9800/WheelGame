package controller;

import view.Dialog.PlayerNewDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuItemActionListener implements ActionListener {

    public MenuItemActionListener(JFrame jFrame) {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        PlayerNewDialog playerNewDialog = new PlayerNewDialog();

    }
}
