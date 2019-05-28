package view.Test;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Main {

  public Main() {
    String languages[] = { "Java", "Perl", "java2s.com", "C++", "Basic", "C#" };
    JList jlst = new JList(languages);


    JFrame jfrm = new JFrame("Use JList");
    jfrm.setLayout(new FlowLayout());
    jfrm.setSize(200, 160);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jlst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    boolean scrollIntoView = true;
    jlst.setSelectedValue("Java", scrollIntoView);
    
    // Get the index of all the selected items
    int[] selectedIx = jlst.getSelectedIndices();

    // Get all the selected items using the indices
    for (int i = 0; i < selectedIx.length; i++) {
      Object sel = jlst.getModel().getElementAt(selectedIx[i]);
    }
    
    
    jfrm.add(new JScrollPane(jlst));
    jfrm.setSize(300, 300);
    jfrm.setVisible(true);
  }

  public static void main(String args[]) {
    new Main();
  }
}