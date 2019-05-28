package view.Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button = new JButton("Click me!");
    private DefaultListModel<String> listModel = new DefaultListModel<String>();
    private JList<String> list = new JList<String>(listModel);
    private int counter = 1;

    public MyFrame() {
        setTitle("Test Updates");

        JTabbedPane tabs = new JTabbedPane();
        add(tabs, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(list);

        tabs.add("Selections", panel);
        panel = new JPanel();

        button.addActionListener(this);
        panel.add(button);

        tabs.add("Options", panel);

        pack();
    }

    @Override
        public void actionPerformed(final ActionEvent event) {
        if (button.equals(event.getSource())) {
            listModel.addElement("Item " + counter++);
        }
    }

    /* Test it! */
    public static void main(String[] args) {
        final MyFrame frame = new MyFrame();
        frame.addWindowListener(new WindowAdapter(){
            @Override public void windowClosing(final WindowEvent e) {
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
        });

        frame.setVisible(true);
    }
}