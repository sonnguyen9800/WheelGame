package view;

import view.ControlPanel.ControlPanel;
import view.Menu.WheelMenuBar;
import view.StatusBar.StatusBar;
import view.SummaryPanel.SummaryPanel;
import view.WheelPanel.WheelPanel;

import javax.swing.*;
import java.awt.*;

public class WheelGameUI extends JFrame {
    public final static int WHEELGAME_WIDTH = 1200;
    public final static int WHEELGAME_HEIGHT = 480;

    private WheelGameUI(){
        super("Wheel Game");

        //setLayout(new GridLayout());
        setLayout(new BorderLayout());


        setSize(WHEELGAME_WIDTH, WHEELGAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        WheelPanel wheelPanel = new WheelPanel();
        add(wheelPanel, BorderLayout.LINE_START);
        wheelPanel.setPreferredSize(new Dimension(400,400));

        SummaryPanel summaryPanel = new SummaryPanel();
        add(summaryPanel, BorderLayout.CENTER);
        summaryPanel.setPreferredSize(new Dimension(400,400));

        ControlPanel controlPanel = new ControlPanel();
        add(controlPanel, BorderLayout.EAST);
        controlPanel.setPreferredSize(new Dimension(400,400));
        add(new StatusBar(), BorderLayout.SOUTH);

        setJMenuBar(new WheelMenuBar(this));
        setBackground(Color.DARK_GRAY);
    }




    public static void main(String[] args) {
        WheelGameUI wheelGameUI = new WheelGameUI();
        wheelGameUI.setVisible(true);
    }
}
