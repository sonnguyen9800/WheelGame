package view.SummaryPanel;


import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * The Summary Panel, where players information are shown
 * Note that the Bettype are represented by Color of the background cell, not by text
 * <p>
 * The list of Players are created by DefaultListModel
 *
 * @see GameEngineCallbackGUI
 */

public class SummaryPanel extends JPanel {

    private DefaultListModel<Player> listPlayerModel = new DefaultListModel<>();
    private JList<Player> playerJList;
    private GameEngineCallbackGUI gameEngineCallbackGUI;
    private JScrollPane pane;

    /**
     * The Constructor, take the GameEngineCallbackGUI parameter
     */
    public SummaryPanel(GameEngineCallbackGUI gameEngineCallbackGUI) {
        String title = "Summary";
        Border border = BorderFactory.createTitledBorder(title);
        this.setBorder(border);
        this.gameEngineCallbackGUI = gameEngineCallbackGUI;

        playerJList = new JList<>(listPlayerModel);
        playerJList.setCellRenderer(new PlayerCellRenderer());

        playerJList.setFixedCellHeight(50);
        playerJList.setFixedCellWidth(380);

        pane = new JScrollPane(playerJList);

        add(pane);

    }

    /**
     * Add new Player method
     */
    public void addnewPlayer(Player player) {
        if (player != null) {
            this.listPlayerModel.addElement(player);
        }
    }

    /**
     * update the summary panel
     */
    public void updateListPlayer() {
        listPlayerModel.removeAllElements();
        for (Player player : gameEngineCallbackGUI.getPlayers()) {
            listPlayerModel.addElement(player);
        }

    }

}
