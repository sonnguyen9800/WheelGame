package view;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.ControlPanel.ControlPanel;
import view.Menu.WheelMenuBar;
import view.StatusBar.StatusBar;
import view.SummaryPanel.SummaryPanel;
import view.WheelPanel.WheelPanel;
import view.interfaces.GameEngineCallback;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameEngineCallbackGUI extends JFrame implements GameEngineCallback {
    public final static int WHEELGAME_WIDTH = 1200;
    public final static int WHEELGAME_HEIGHT = 480;

    private WheelPanel wheelPanel;

    public GameEngineCallbackGUI(){
        super("Wheel Game");

        //setLayout(new GridLayout());
        setLayout(new BorderLayout());


        setSize(WHEELGAME_WIDTH, WHEELGAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        wheelPanel = new WheelPanel();
        add(wheelPanel, BorderLayout.CENTER);
        wheelPanel.setPreferredSize(new Dimension(400,400));

        SummaryPanel summaryPanel = new SummaryPanel();
        add(summaryPanel, BorderLayout.WEST);
        summaryPanel.setPreferredSize(new Dimension(400,400));

        ControlPanel controlPanel = new ControlPanel();
        add(controlPanel, BorderLayout.EAST);
        controlPanel.setPreferredSize(new Dimension(400,400));
        add(new StatusBar(), BorderLayout.SOUTH);

        setJMenuBar(new WheelMenuBar(this));
        setBackground(Color.DARK_GRAY);

        setVisible(true);
    }




    public static void main(String[] args) {
        GameEngineCallbackGUI gameEngineCallbackGUI = new GameEngineCallbackGUI();

    }

    @Override
    public void nextSlot(Slot slot, GameEngine engine) {
        int index = 0;
        ArrayList list = new ArrayList(engine.getWheelSlots());
        index = list.indexOf(slot);
        this.wheelPanel.paintMovingBall(index);
    }

    @Override
    public void result(Slot winningSlot, GameEngine engine) {
        int index = 0;
        ArrayList list = new ArrayList(engine.getWheelSlots());
        index = list.indexOf(winningSlot);
        this.wheelPanel.paintMovingBall(index);
    }

    
}
