package view.SummaryPanel;

import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SummaryPanel extends JPanel {
    private Player players[] = {
            new SimplePlayer("0", "Adam", 1000),
            new SimplePlayer("1", "Eve", 1000),
            new SimplePlayer("2", "Lilith", 1000),
            new SimplePlayer("0", "Adam", 1000),
            new SimplePlayer("1", "Eve", 1000),
            new SimplePlayer("2", "Lilith", 1000),
            new SimplePlayer("0", "Adam", 1000),
            new SimplePlayer("1", "Eve", 1000),
            new SimplePlayer("2", "Lilith", 1000),
            new SimplePlayer("0", "Adam", 1000),
            new SimplePlayer("1", "Eve", 1000),
            new SimplePlayer("2", "Lilith", 1000)
    };


    private JList playerJList;
    public SummaryPanel(){
        String title = "Summary";
        Border border = BorderFactory.createTitledBorder(title);
        this.setBorder(border);

        playerJList = new JList(players);
        playerJList.setCellRenderer(new PlayerCellRenderer());
        playerJList.setFixedCellHeight(50);
        playerJList.setFixedCellWidth(380);

        JScrollPane pane = new JScrollPane(playerJList);

        add(pane);


    }

}
