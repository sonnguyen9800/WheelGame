package view.StatusBar;

import javax.swing.*;
import java.awt.*;
/**
 * This Status Bar showing the status of the game
 *
 * There are three possible status:
 * 1) "Ready" Status
 * 2) "Spinning" Status
 * @see view.GameEngineCallbackGUI
 * 3) "Update Result" Status
 * @see view.GameEngineCallbackGUI
 *
 */
public class StatusBar extends JLabel {
    public StatusBar(){
        super();
        super.setPreferredSize(new Dimension(100, 16));
        setMessage("Ready");
    }
    public void setMessage(String text){
        setText(" Status:  "+ text);
    }
}
