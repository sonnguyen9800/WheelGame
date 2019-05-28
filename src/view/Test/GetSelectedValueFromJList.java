package view.Test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
 
public class GetSelectedValueFromJList extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = 1L;
 
    private JList list;
    private JButton button;
 
    public GetSelectedValueFromJList() {
 
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
 
        Object[] data = { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };
 
        list = new JList(data);
        button = new JButton("Check");
 
        button.addActionListener(this);
 
        // add list to frame
        add(list);
        add(button);
 
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check")) {
            int index = list.getSelectedIndex();
            System.out.println("Index Selected: " + index);
            String s = (String) list.getSelectedValue();
            System.out.println("Value Selected: " + s);
        }
    }
 
    private static void createAndShowGUI() {
 
  //Create and set up the window.

      JFrame frame = new GetSelectedValueFromJList();
      //Display the window.
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
 
    public static void main(String[] args) {
 
          //Schedule a job for the event-dispatching thread:

          //creating and showing this application's GUI.

          javax.swing.SwingUtilities.invokeLater(new Runnable() {

        public void run() {

            createAndShowGUI();

        }

          });
    }
 
}