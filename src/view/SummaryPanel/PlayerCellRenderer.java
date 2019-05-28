package view.SummaryPanel;

import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class PlayerCellRenderer extends JLabel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(118, 128, 125);
    private GameEngineCallbackGUI gameEngineCallbackGUI = (GameEngineCallbackGUI) GameEngineCallbackGUI.getSingletonInstance();
    public PlayerCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        Player entry = (Player) value;
        String dataEntry = " ID: " + entry.getPlayerId() + " Player: " + entry.getPlayerName()
                + "; Total Points: "
                + entry.getPoints()
                + " Bet: " + entry.getBet();

        setText(dataEntry);

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

        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        }else {
            setForeground(Color.BLACK);
        }
        return this;
    }
}