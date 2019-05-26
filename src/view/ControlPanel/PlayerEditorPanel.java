package view.ControlPanel;

import model.enumeration.Color;
import model.interfaces.Player;

import javax.swing.*;

import java.awt.*;

import static javax.swing.GroupLayout.Alignment.*;

public class PlayerEditorPanel extends JPanel {
    private JLabel playerNameLabel;
    private JLabel playerBetpointLabel;
    private JLabel playerBettypeLabel;

    private JTextField playerNameTextfield;
    private JTextField playerBetpointTextfield;

    private JComboBox box;
    private Color[] colorsBox;

    private JButton okButton;
    private JButton cancelButton;
    private JButton destroyButton;

    public PlayerEditorPanel(Player player){
        GroupLayout groupLayout = new GroupLayout(this);
        setLayout(groupLayout);


        playerNameLabel = new JLabel("Player Name: ");
        playerBetpointLabel = new JLabel("Player Bet Point: ");
        playerBettypeLabel = new JLabel("Player Bet Type: ");

        playerNameTextfield = new JTextField(10);
        playerNameTextfield.setText(player.getPlayerName());

        playerBetpointTextfield = new JTextField(10);
        playerBetpointTextfield.setText(String.valueOf(player.getBet()));


        okButton = new JButton("Accept");
        okButton.setPreferredSize(new Dimension(150, 100));
        cancelButton = new JButton("Cancel/Reset");
        destroyButton = new JButton("Remove Player");

        colorsBox = new Color[] {Color.RED, Color.BLACK, Color.GREEN0, Color.GREEN00};
        box = new JComboBox<>(colorsBox);


        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(TRAILING)
                        .addComponent(playerNameLabel)
                        .addComponent(playerBetpointLabel)
                        .addComponent(playerBettypeLabel))
                .addGroup(groupLayout.createParallelGroup()
                        .addComponent(playerNameTextfield)
                        .addComponent(playerBetpointTextfield)
                        .addComponent(box, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                .addGroup(groupLayout.createSequentialGroup())
                        .addComponent(okButton)
                        .addComponent(cancelButton)
                        .addComponent(destroyButton))
        );

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(BASELINE)
                        .addComponent(playerNameLabel)
                        .addComponent(playerNameTextfield))
                .addGroup(groupLayout.createParallelGroup(BASELINE)
                        .addComponent(playerBetpointLabel)
                        .addComponent(playerBetpointTextfield))
                .addGroup(groupLayout.createParallelGroup(BASELINE)
                        .addComponent(playerBettypeLabel)
                        .addComponent(box, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup())
                        .addComponent(okButton)
                        .addComponent(cancelButton)
                        .addComponent(destroyButton)

        );



    }
}
