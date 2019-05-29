package view.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemOptions extends JMenu {
    private JMenuItem helpMenuItem;
    private JMenuItem restartMenuItem;
    private JMenuItem quitGameMenuItem;
    private JMenuItem aboutMenuItem;

    public MenuItemOptions() {
        super("Menu");

        helpMenuItem = new JMenuItem("Help");
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String msg = " - Create a new Player by click on 'Add Player'\n" +
                        " - NOTE* The id of player must be different\n" +
                        " - Choose a player you want to configure on the right panel\n" +
                        " - Edit his bet/name/Bettype on the right panel - After finish just click 'Accept'\n" +
                        " - If you want to cancel the change then click 'Cancel'\n" +
                        " - If all players have bet, the wheel will automatically spin\n" +
                        " - Of course, you can manually spin by the 'Spin the Wheel' Button\n" +
                        " - Enjoy";

                JOptionPane optionPane = new NarrowOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "Quick Tips");
                dialog.setVisible(true);
            }
        });

        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String msg = "<html>Quick Game created by Sonng for Assignment 1 - Further Programming" +
                        "<br>Student name: Son Nguyen Hoang </br>" +
                        "<br>Student id: s3634703 </br> \n" +
                        "Enjoy";

                JOptionPane optionPane = new NarrowOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "Quick Tips");
                dialog.setVisible(true);
            }
        });

        quitGameMenuItem = new JMenuItem("Rule");
        quitGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane optionPane = new NarrowOptionPane();
                optionPane.setMessage("Just a funny little game ~ 'I am lazy ...'");
                JDialog dialog = optionPane.createDialog(null, "Rules");
                dialog.setVisible(true);
            }
        });

        add(helpMenuItem);
        add(aboutMenuItem);
        add(quitGameMenuItem);
    }

    class NarrowOptionPane extends JOptionPane {

        NarrowOptionPane() {
        }

        public int getMaxCharactersPerLineCount() {
            return 200;
        }
    }
}
