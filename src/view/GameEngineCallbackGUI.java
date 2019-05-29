package view;

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
/**
 * Main UI
 *
 * It contains 5 Panel:
 * 1) WheelPanel (Center)
 * 2) SummaryPanel (Left)
 * 3) ControlPanel (Right)
 * 4) Menubar (WheelMenuBar) (Top)
 * 5) StatusBar (Below)
 *
 * @author sonng s3634703
 */
public class GameEngineCallbackGUI extends JFrame implements GameEngineCallback {
    private final static int WHEELGAME_WIDTH = 1200;
    private final static int WHEELGAME_HEIGHT = 480;


    private WheelPanel wheelPanel;
    private ControlPanel controlPanel;
    private SummaryPanel summaryPanel;
    private StatusBar statusBar;
    private GameEngine gameEngine;

    public GameEngineCallbackGUI(GameEngine gameEngine){
        super("Wheel Game");
        setLayout(new BorderLayout());
        this.gameEngine = gameEngine;

        setSize(WHEELGAME_WIDTH, WHEELGAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        wheelPanel = new WheelPanel();
        add(wheelPanel, BorderLayout.CENTER);
        wheelPanel.setPreferredSize(new Dimension(400,400));

        summaryPanel = new SummaryPanel(this);
        add(summaryPanel, BorderLayout.WEST);
        summaryPanel.setPreferredSize(new Dimension(400,400));

        controlPanel = new ControlPanel(this, gameEngine);
        add(controlPanel, BorderLayout.EAST);
        controlPanel.setPreferredSize(new Dimension(400,400));

        statusBar = new StatusBar();
        add(statusBar, BorderLayout.SOUTH);

        WheelMenuBar wheelMenuBar = new WheelMenuBar(this, this);
        setJMenuBar(wheelMenuBar);


        setBackground(Color.DARK_GRAY);
        setVisible(true);

    }


    /**
     * Create a new Player and update the new Player to the SummaryPanel and ControlPanel
     *
     * @author SonNg 3634703
     */

    public void createNewPlayer(Player player){
        gameEngine.addPlayer(player);
        summaryPanel.addnewPlayer(player);
        controlPanel.getPlayerSelectionPanel().updateComboPlayers();
    }

    /**
     * set a Selected player, this player is interacted and updated inside ControlPanel
     */

    public void setSelectedPlayer(Player player){
        this.controlPanel.getPlayerEditorPanel().setSelectedPlayer(player);
    }

    /**
     * Remove a Player and update the changes to the SummaryPanel and ControlPanel
     */
    public void removePlayer(Player player){
        gameEngine.removePlayer(player);
    }

    /**
     * Reload the PlayerSelectionPanel and PlayerEditorPanel inside ControlPanel
     */
    public void refreshPlayerSelectionPane(){
        this.controlPanel.getPlayerSelectionPanel().updateComboPlayers();
        this.controlPanel.getPlayerEditorPanel().refreshEditorPanel();
    }

    /**
     * Reload the Summary Panel
     */
    public void refreshSummaryPanel(){
        this.summaryPanel.updateListPlayer();


    }
    /**
     * Get All current Playes
     */
    public List<Player> getPlayers(){
        return (List<Player>) gameEngine.getAllPlayers();
    }

    @Override
    public void nextSlot(Slot slot, GameEngine engine) {
        int index;
        List<Slot> list = (List<Slot>) engine.getWheelSlots();
        index = list.indexOf(slot);
        int finalIndex = index;
        statusBar.setMessage("Spinning");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                wheelPanel.paintMovingBall(finalIndex);
            }
        });
    }

    @Override
    public void result(Slot winningSlot, GameEngine engine) {

        int index;
        ArrayList<Slot> list = new ArrayList<>(engine.getWheelSlots());
        index = list.indexOf(winningSlot);

        int finalIndex = index;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                wheelPanel.paintMovingBall(finalIndex);
            }
        });
        refreshSummaryPanel();
        refreshPlayerSelectionPane();
        statusBar.setMessage("New Result Updated");

    }



}
