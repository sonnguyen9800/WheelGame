package view.Test;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectingJListSample {
  public static void main(String args[]) {
    String labels[] = { "A", "B", "C", "D", "E", "F", "G", "H" };
    JFrame frame = new JFrame("Selecting JList");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JList jlist = new JList(labels);
    JScrollPane scrollPane1 = new JScrollPane(jlist);
    frame.add(scrollPane1, BorderLayout.CENTER);

    ListSelectionListener listSelectionListener = new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
        System.out.println("First index: " + listSelectionEvent.getFirstIndex());
        System.out.println(", Last index: " + listSelectionEvent.getLastIndex());
        boolean adjust = listSelectionEvent.getValueIsAdjusting();
        System.out.println(", Adjusting? " + adjust);
        if (!adjust) {
          JList list = (JList) listSelectionEvent.getSource();
          int selections[] = list.getSelectedIndices();
          Object selectionValues[] = list.getSelectedValues();
          for (int i = 0, n = selections.length; i < n; i++) {
            if (i == 0) {
              System.out.println(" Selections: ");
            }
            System.out.println(selections[i] + "/" + selectionValues[i] + " ");
          }
        }
      }
    };
    jlist.addListSelectionListener(listSelectionListener);

    frame.setSize(350, 200);
    frame.setVisible(true);
  }
}