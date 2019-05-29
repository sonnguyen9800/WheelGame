package view.ControlPanel;

import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.*;

public class PlayerEditorPanel extends JPanel {

    private Player selectedPlayer = new SimplePlayer("?", "No Player Choosen", 0);
    private Player newPlayer = new SimplePlayer("?", "No Player Created", 0);
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
        box = new JComboBox<>(colorsBox);

        populate(groupLayout);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    newPlayer = new SimplePlayer(selectedPlayer.getPlayerId(), playerNameTextfield.getText(),
                            selectedPlayer.getPoints());
                    newPlayer.setBetType((BetType) box.getSelectedItem());

                    if (!newPlayer.setBet(Integer.parseInt(playerBetpointTextfield.getText()))){
                        JOptionPane.showMessageDialog(null, "Your Bet is invalid");
                    } else{
                        System.out.println(Integer.parseInt(playerBetpointTextfield.getText()));
                        System.out.println("New Player created: " + newPlayer.toString());
                        updatePlayer(selectedPlayer, newPlayer);
                        GameEngineCallbackGUI gameEngineCallbackGUI = (GameEngineCallbackGUI) GameEngineCallbackGUI.getSingletonInstance();
                        gameEngineCallbackGUI.refreshSummaryPanel();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error in Input");
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                playerNameTextfield.setText(selectedPlayer.getPlayerName());
                playerBetpointTextfield.setText(String.valueOf(selectedPlayer.getBet()));
                box.setSelectedItem(selectedPlayer.getBetType());
            }
        });

        destroyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int n = JOptionPane.showConfirmDialog(
                        null,
                        "Would you like to delete this player",
                        "Need confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.OK_OPTION){
                    GameEngineCallbackGUI gameEngineCallbackGUI = (GameEngineCallbackGUI) GameEngineCallbackGUI.getSingletonInstance();
                    gameEngineCallbackGUI.removePlayer(selectedPlayer);
                    gameEngineCallbackGUI.refreshSummaryPanel();
                    gameEngineCallbackGUI.refreshPlayerSelectionPane();
                    resetTextArea();
                }

            }
        });

    }
    private void populate(GroupLayout groupLayout){

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

    private void updatePlayer(Player oldPlayer, Player newPlayer){
        oldPlayer.setPlayerName(newPlayer.getPlayerName());
        oldPlayer.setBet(newPlayer.getBet());
        oldPlayer.setBetType(newPlayer.getBetType());
    }

    private void resetTextArea(){
        playerNameTextfield.setText("");
        playerBetpointTextfield.setText("");
    }
}
