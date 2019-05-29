package view.Test;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JayFrame extends JFrame {

    public JayFrame() {
        super("My Frame");
        setContentPane(new DrawPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 675);
        setResizable(false);
        setVisible(true);
    }

    class DrawPane extends JPanel {

        private int x = 0;

        public DrawPane() {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x += 110;
                    if (x >= 1000) {
                        x = 1000;
                        ((Timer)e.getSource()).stop();
                    }
                    repaint();
                }
            });
            timer.start();
        }

        public void paintComponent(Graphics g) {
            //Paint stuff
            super.paintComponent(g);

            g.fillRect(x, 10, 100, 100);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                new JayFrame();
            }
        });
    }
}