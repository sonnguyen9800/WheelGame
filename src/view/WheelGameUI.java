package view;

import view.ControlPanel.ControlPanel;
import view.Menu.WheelMenuBar;
import view.SummaryPanel.SummaryPanel;
import view.WheelPanel.WheelPanel;

import javax.swing.*;
import java.awt.*;

public class WheelGameUI extends JFrame {
    public final static int WHEELGAME_WIDTH = 1200;
    public final static int WHEELGAME_HEIGHT = 480;

    private WheelGameUI(){
        super("Wheel Game");

        setLayout(new GridLayout());
        setSize(WHEELGAME_WIDTH, WHEELGAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new WheelPanel());
        add(new SummaryPanel());
        add(new ControlPanel());

        setJMenuBar(new WheelMenuBar());
        setBackground(Color.DARK_GRAY);
    }




    public static void main(String[] args) {
        WheelGameUI wheelGameUI = new WheelGameUI();
        wheelGameUI.setVisible(true);
    }
}
