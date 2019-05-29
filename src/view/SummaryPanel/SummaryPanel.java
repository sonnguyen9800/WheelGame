package view.SummaryPanel;


import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.border.Border;


public class SummaryPanel extends JPanel {

    private DefaultListModel<Player> listPlayerModel = new DefaultListModel<>();
    private JList<Player> playerJList;
    private GameEngineCallbackGUI gameEngineCallbackGUI;
    private JScrollPane pane;

    public SummaryPanel(GameEngineCallbackGUI gameEngineCallbackGUI){
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

    public void addnewPlayer(Player player) {
        if (player != null){
            this.listPlayerModel.addElement(player);
        }
    }

    public void updateListPlayer(){
        listPlayerModel.removeAllElements();
        for (Player player : gameEngineCallbackGUI.getPlayers()){
            listPlayerModel.addElement(player);
        }

    }

}
