package view.Test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class AgendaView extends JFrame {

   private static final int PREF_W = 500;
   private static final int PREF_H = 300;
   private JLabel firstNameLabel, lastNameLabel, adressLabel, phoneNumberLabel,
         extraInfoLabel;
   private JButton editButton, addButton, deleteButton, showButton;
   private JPanel labels, gui, buttons;
   private DefaultListModel<String> model;
   private JList<String> list;
   private JScrollPane scrollPane;

   public AgendaView() {

      super("***Agenda View***");

      gui = new JPanel(new BorderLayout(2, 2));
      gui.setBorder(new TitledBorder("Owner"));

      labels = new JPanel(new GridLayout(0, 1, 1, 1));
      labels.setBorder(new TitledBorder("Contact "));

      buttons = new JPanel(new GridLayout(1, 0, 1, 1));

      editButton = new JButton("Edit");
      addButton = new JButton("Add");
      deleteButton = new JButton("Delete");
      showButton = new JButton("Show");

      editButton.setEnabled(false);
      addButton.setEnabled(false);
      deleteButton.setEnabled(false);
      showButton.setEnabled(false);

      buttons.add(showButton);
      buttons.add(editButton);
      buttons.add(addButton);
      buttons.add(deleteButton);

      firstNameLabel = new JLabel("First name:                                         ");
      lastNameLabel = new JLabel("Last name: ");
      adressLabel = new JLabel("Adress: ");
      phoneNumberLabel = new JLabel("Phone number: ");
      extraInfoLabel = new JLabel("Extra info: ");

      labels.add(firstNameLabel);
      labels.add(lastNameLabel);
      labels.add(adressLabel);
      labels.add(phoneNumberLabel);
      labels.add(extraInfoLabel);

      model = new DefaultListModel<String>();
      list = new JList<String>(model);
      String[] eles = { "Ciprian Aftode", "Andrei Batinas", "Bogdan Fichitiu",
            "Valentin Pascau" };
      for (String ele : eles) {
         model.addElement(ele);
      }
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      // list.setVisibleRowCount(-1);
      list.addListSelectionListener(new ListSelectionListener() {
         @Override
         public void valueChanged(ListSelectionEvent lse) {
            firstNameLabel.setText("First name:   first name");
            lastNameLabel.setText("Last name:   last name");
            adressLabel.setText("Address:   Address");
            phoneNumberLabel.setText("Phone number: PhoneNumber");
            extraInfoLabel.setText("Occupation: ExtraInfo");
         }
      });

      int ebGap = 8;
      list.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));

      scrollPane = new JScrollPane(list);

      gui.add(labels, BorderLayout.CENTER);
      gui.add(scrollPane, BorderLayout.WEST);
      gui.add(buttons, BorderLayout.SOUTH);
      add(gui);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }


   private static void createAndShowGui() {
      AgendaView frame = new AgendaView();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }

}