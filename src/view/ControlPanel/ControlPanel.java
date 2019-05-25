package view.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    PlayerEditorPanel playerEditorPanel = new PlayerEditorPanel();
    SpinPanel spinPanel = new SpinPanel();
    public ControlPanel(){

        this.setLayout(new GridLayout(2, 0, 10, 0));
        this.add(playerEditorPanel);
        this.add(spinPanel);


    }
}
