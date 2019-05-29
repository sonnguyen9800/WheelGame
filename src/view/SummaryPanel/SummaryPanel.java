package view.SummaryPanel;


import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.border.Border;


public class SummaryPanel extends JPanel {

    private DefaultListModel<Player> listPlayerModel = new DefaultListModel<>();
    private JList<Player> playerJList;


    public SummaryPanel(){
        String title = "Summary";
        Border border = BorderFactory.createTitledBorder(title);
        this.setBorder(border);

        playerJList = new JList<>(listPlayerModel);
        playerJList.setCellRenderer(new PlayerCellRenderer());

        playerJList.setFixedCellHeight(50);
        playerJList.setFixedCellWidth(380);

        JScrollPane pane = new JScrollPane(playerJList);

        add(pane);

    }

    public void addnewPlayer(Player player) {
        if (player != null){
            this.listPlayerModel.addElement(player);
        }
    }

    public void updateListPlayer(){
        listPlayerModel.removeAllElements();
        GameEngineCallbackGUI gameEngineCallbackGUI = (GameEngineCallbackGUI) GameEngineCallbackGUI.getSingletonInstance();
        for (Player player : gameEngineCallbackGUI.getPlayers()){
            listPlayerModel.addElement(player);
        }
        playerJList = new JList<>(listPlayerModel);
        playerJList.setCellRenderer(new PlayerCellRenderer());
        playerJList.setFixedCellHeight(50);
        playerJList.setFixedCellWidth(380);
        JScrollPane pane = new JScrollPane(playerJList);

        add(pane);

    }

}
