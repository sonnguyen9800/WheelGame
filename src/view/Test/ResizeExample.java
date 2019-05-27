package view.Test;

import javax.swing.*;
import java.awt.*;

/**
 * User: Dejan
 * Date: 20.11.2010
 * Time: 14:52:57
 */
public class ResizeExample extends JFrame {


    public ResizeExample(){
        JPanel panel = new JPanel();

        JButton button = new JButton("test");
        // You probably dont want buttons to resize, so wrap them to another panel:
        JPanel buttonsWrapper = new JPanel();
        buttonsWrapper.add(button);

        String[][] data = new String[][]{new String[]{"a", "b"}, new String[]{"a", "b"}, new String[]{"a", "xx"}};
        JTable table = new JTable(data, new String[]{"aa", "bb"});
        JScrollPane scroll = new JScrollPane(table);
        panel.setLayout(new BorderLayout());
        panel.add(buttonsWrapper, BorderLayout.NORTH);
        // If you ommit the constraint, the component will be added to BorderLayout.CENTER, which takes up whatever space is left
        panel.add(scroll);

        setLayout(new BorderLayout());
        // Again, added to the center:
        add(panel);

        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new ResizeExample();
    }
}