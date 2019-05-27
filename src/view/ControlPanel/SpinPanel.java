package view.ControlPanel;

import controller.SpinPanelController;

import javax.swing.*;
import java.awt.*;

public class SpinPanel extends JPanel {
    public SpinPanel(){
        setSize(300, 180);
        JButton spin = new JButton();


        spin.setText("SPIN THE WHEEL");
        spin.setPreferredSize(new Dimension(200,75));
        spin.addMouseListener(new SpinPanelController());

        add(spin);
    }
}
