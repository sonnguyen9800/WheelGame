package view;

import model.SimplePlayer;
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
    public final static int WHEELGAME_WIDTH = 1200;
    public final static int WHEELGAME_HEIGHT = 480;

    private List<Player> players = new ArrayList<Player>();
    private Player selectedPlayer;

    private static GameEngineCallback singletonInstance = new GameEngineCallbackGUI();

    public static GameEngineCallback getSingletonInstance()
    {
        return singletonInstance;
    }

    private WheelPanel wheelPanel;
    private ControlPanel controlPanel;
    private SummaryPanel summaryPanel;
    private StatusBar statusBar;
    private WheelMenuBar wheelMenuBar;

    private GameEngineCallbackGUI(){
        super("Wheel Game");
        populate();
    }

    public void createNewPlayer(Player player){
        players.add(player);
        summaryPanel.addnewPlayer(player);
        controlPanel.getPlayerSelectionPanel().updateComboPlayers();
        logAllPlayers();
    }

    public void setSelectedPlayer(Player player){
        this.selectedPlayer = player;
        this.controlPanel.getPlayerEditorPanel().setSelectedPlayer(player);
        logSelectedPlayers();

    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                //GameEngineCallbackGUI.getSingletonInstance();
            }
        });
    }


    public void populate(){
        //setLayout(new GridLayout());
        setLayout(new BorderLayout());

        players.add(new SimplePlayer("1", "John", 10));
        players.add(new SimplePlayer("1", "Joh423", 10));

        setSize(WHEELGAME_WIDTH, WHEELGAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        wheelPanel = new WheelPanel();
//        add(wheelPanel, BorderLayout.CENTER);
//        wheelPanel.setPreferredSize(new Dimension(400,400));

        summaryPanel = new SummaryPanel();
        add(summaryPanel, BorderLayout.WEST);
        summaryPanel.setPreferredSize(new Dimension(400,400));

        controlPanel = new ControlPanel(this);
        add(controlPanel, BorderLayout.EAST);
        controlPanel.setPreferredSize(new Dimension(400,400));

        statusBar = new StatusBar();
        add(statusBar, BorderLayout.SOUTH);

        wheelMenuBar = new WheelMenuBar(this);
        setJMenuBar(wheelMenuBar);

        setBackground(Color.DARK_GRAY);
        setVisible(true);
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

    public void logAllPlayers(){
        System.out.println("All Players: ");
        for (Player player : players){
            System.out.println(player.toString());
        }
    }
    public void logSelectedPlayers(){
        if (selectedPlayer != null){
            System.out.println("Selected:" + selectedPlayer.toString());
        }else{
            System.out.println("Null");
        }
    }

}
