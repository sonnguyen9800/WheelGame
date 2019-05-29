package view.SummaryPanel;

import model.interfaces.Player;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
/**
 * This ListCellRenderer helps to draw each Player on the SummaryPanel
 * @see SummaryPanel for more information
 *
 */

class PlayerCellRenderer extends JLabel implements ListCellRenderer {
    PlayerCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }
    /**
     * This ListCellRenderer helps to draw each Player on the SummaryPanel
     * @see SummaryPanel for more information
     * @param value is the choosen one
     */
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        Player entry = (Player) value;
        String dataEntry = " ID: " + entry.getPlayerId() + " Player: " + entry.getPlayerName()
                + "; Total Points: "
                + entry.getPoints()
                + " Bet: " + entry.getBet();

        setText(dataEntry);
        /**
         * Background color of each cell is determined by the Bettype
         * @see Player
         * @see SummaryPanel for more information
         *
         */
        switch (entry.getBetType()){
            case BLACK:
                setBackground(Color.GRAY);
                break;
            case RED:
                setBackground(Color.RED);
                break;
            case ZEROS:
                setBackground(Color.GREEN);
                break;
                default:
                    setBackground(Color.WHITE);
                    break;
        }
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(border);

        return this;
    }
}