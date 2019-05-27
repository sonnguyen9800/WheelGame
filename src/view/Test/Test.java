package view.Test;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    public Test() {
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // define the position
        int locX = 200;
        int locY = 200;

        // draw a line (there is no drawPoint..)

    }

    public static void main(String[] args) {
        Test test = new Test(); 
    }
}