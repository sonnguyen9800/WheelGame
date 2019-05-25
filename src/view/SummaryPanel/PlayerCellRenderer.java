package view.SummaryPanel;

import model.interfaces.Player;

import javax.swing.*;
import java.awt.*;

class PlayerCellRenderer extends JLabel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(118, 128, 125);

    public PlayerCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        Player entry = (Player) value;
        String dataEntry = "    Player Name: " + entry.getPlayerName() + " Points: " + entry.getPoints() + " Bet: " + entry.getBetType();
        setText(dataEntry);


        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}