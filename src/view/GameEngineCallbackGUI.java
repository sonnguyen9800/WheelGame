package view;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
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
import java.util.List;

public class GameEngineCallbackGUI extends JFrame implements GameEngineCallback {
    private final static int WHEELGAME_WIDTH = 1200;
    private final static int WHEELGAME_HEIGHT = 480;

    private static GameEngineCallback singletonInstance = new GameEngineCallbackGUI();

    public static GameEngineCallback getSingletonInstance()
    {
        return singletonInstance;
    }

    private WheelPanel wheelPanel;
    private ControlPanel controlPanel;
    private SummaryPanel summaryPanel;
    private StatusBar statusBar;

    private GameEngineCallbackGUI(){
        super("Wheel Game");
        populate();
    }

    public void createNewPlayer(Player player){
        GameEngineImpl gameEngine = (GameEngineImpl) GameEngineImpl.getSingletonInstance();
        gameEngine.addPlayer(player);
        summaryPanel.addnewPlayer(player);
        controlPanel.getPlayerSelectionPanel().updateComboPlayers();
    }

    public void setSelectedPlayer(Player player){
        this.controlPanel.getPlayerEditorPanel().setSelectedPlayer(player);
    }

    public void removePlayer(Player player){
        GameEngineImpl gameEngine = (GameEngineImpl) GameEngineImpl.getSingletonInstance();
        gameEngine.removePlayer(player);
    }

    public void refreshPlayerSelectionPane(){
        this.controlPanel.getPlayerSelectionPanel().updateComboPlayers();
    }
    public void refreshSummaryPanel(){
        this.summaryPanel.updateListPlayer();
    }

    public List<Player> getPlayers(){
        GameEngineImpl gameEngine = (GameEngineImpl) GameEngineImpl.getSingletonInstance();
        return (List<Player>) gameEngine.getAllPlayers();

    }


    private void populate(){
        setLayout(new BorderLayout());

        setSize(WHEELGAME_WIDTH, WHEELGAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        wheelPanel = new WheelPanel();
        add(wheelPanel, BorderLayout.CENTER);
        wheelPanel.setPreferredSize(new Dimension(400,400));

        summaryPanel = new SummaryPanel();
        add(summaryPanel, BorderLayout.WEST);
        summaryPanel.setPreferredSize(new Dimension(400,400));

        controlPanel = new ControlPanel(this);
        add(controlPanel, BorderLayout.EAST);
        controlPanel.setPreferredSize(new Dimension(400,400));

        statusBar = new StatusBar();
        add(statusBar, BorderLayout.SOUTH);

        WheelMenuBar wheelMenuBar = new WheelMenuBar(this);
        setJMenuBar(wheelMenuBar);


        setBackground(Color.DARK_GRAY);
        setVisible(true);
    }


    @Override
    public void nextSlot(Slot slot, GameEngine engine) {
        int index = 0;
        ArrayList list = new ArrayList(engine.getWheelSlots());
        index = list.indexOf(slot);
        int finalIndex = index;
        statusBar.setMessage("Spinning");
        SwingUtilities.invokeLater(() -> wheelPanel.paintMovingBall(finalIndex));
    }

    @Override
    public void result(Slot winningSlot, GameEngine engine) {

        int index;
        ArrayList list = new ArrayList(engine.getWheelSlots());
        index = list.indexOf(winningSlot);

        int finalIndex = index;
        SwingUtilities.invokeLater(() -> wheelPanel.paintMovingBall(finalIndex));
        refreshSummaryPanel();
        statusBar.setMessage("New Result Updated");

    }



}
