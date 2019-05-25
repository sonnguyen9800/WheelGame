package view.SummaryPanel;

import model.interfaces.Player;

import javax.swing.*;
import java.awt.*;

class PlayerCellRenderer extends JLabel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public PlayerCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        Player entry = (Player) value;
        setText(entry.getPlayerName() + entry.getPoints() + entry.getBetType().toString());


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