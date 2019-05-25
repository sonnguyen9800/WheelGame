package view.SummaryPanel;

import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SummaryPanel extends JPanel {
    private Player players[] = {
            new SimplePlayer("0", "Adam", 1000),
            new SimplePlayer("1", "Eve", 1000),
            new SimplePlayer("2", "Lilith", 1000)
    };


    private JList playerJList;
    public SummaryPanel(){
        setBackground(Color.GRAY);

        playerJList = new JList(players);
        playerJList.setCellRenderer(new PlayerCellRenderer());
        playerJList.setVisibleRowCount(4);
        JScrollPane pane = new JScrollPane(playerJList);

        add(pane);


    }

}
