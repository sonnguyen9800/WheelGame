package view.ControlPanel;

import model.SimplePlayer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ControlPanel extends JPanel {




    PlayerEditorPanel playerEditorPanel = new PlayerEditorPanel(new SimplePlayer("2", "Adam", 1000));
    SpinPanel spinPanel = new SpinPanel();
    public ControlPanel(){


        String title = "Controller";
        Border border = BorderFactory.createTitledBorder(title);
        this.setBorder(border);
        this.setLayout(new BorderLayout());
        this.add(playerEditorPanel, BorderLayout.CENTER);
        this.add(spinPanel, BorderLayout.SOUTH);

    }
}
