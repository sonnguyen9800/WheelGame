package view.ControlPanel;

import model.SimplePlayer;
import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static javax.swing.GroupLayout.Alignment.*;

public class PlayerEditorPanel extends JPanel {

    private Player selectedPlayer = new SimplePlayer("?", "No Player Choosen", 0);

    private JLabel playerNameLabel;
    private JLabel playerBetpointLabel;
    private JLabel playerBettypeLabel;

    private JTextField playerNameTextfield;
    private JTextField playerBetpointTextfield;

    private JComboBox box;
    private BetType[] colorsBox;

    private JButton okButton;
    private JButton cancelButton;
    private JButton destroyButton;

    private GroupLayout groupLayout;
    public PlayerEditorPanel(){
        groupLayout = new GroupLayout(this);
        setLayout(groupLayout);


        playerNameLabel = new JLabel("Player Name: ");
        playerBetpointLabel = new JLabel("Player Bet Point: ");
        playerBettypeLabel = new JLabel("Player Bet Type: ");

        playerNameTextfield = new JTextField(10);
        playerBetpointTextfield = new JTextField(10);

        playerNameTextfield.setText(selectedPlayer.getPlayerName());
        playerBetpointTextfield.setText(String.valueOf(selectedPlayer.getBet()));


        okButton = new JButton("Accept");
        okButton.setPreferredSize(new Dimension(150, 100));
        cancelButton = new JButton("Cancel/Reset");
        destroyButton = new JButton("Remove Player");

        colorsBox = new BetType[] {BetType.RED, BetType.BLACK, BetType.ZEROS};
        box = new JComboBox<BetType>(colorsBox);

        populate(groupLayout);



    }
    public void populate(GroupLayout groupLayout){

        playerNameTextfield.setText(selectedPlayer.getPlayerName());
        playerBetpointTextfield.setText(String.valueOf(selectedPlayer.getBet()));

        box.setSelectedItem(selectedPlayer.getBetType());

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

    public void setSelectedPlayer(Player player){
        this.selectedPlayer = player;
        //System.out.println(player.toString());
        populate(groupLayout);
    }
}
