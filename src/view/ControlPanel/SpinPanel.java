package view.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class SpinPanel extends JPanel {
    public SpinPanel(){
        setSize(300, 180);
        JButton spin = new JButton();

        spin.setBackground(Color.RED);

        spin.setText("SPIN THE WHEEL");

        add(spin);
    }
}
