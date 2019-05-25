package view.StatusBar;

import javax.swing.*;
import java.awt.*;

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
