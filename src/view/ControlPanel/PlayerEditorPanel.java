package view.ControlPanel;

import controller.SpinPanelController;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.*;
/**
 * This Panel provides tool to change Player bettype/ bet point and name
 * events
 * This is inside ControlPanel
 * @see SimplePlayer
 * @see ControlPanel
 * @see PlayerSelectionPanel
 */
public class PlayerEditorPanel extends JPanel {

    private Player selectedPlayer = new SimplePlayer("?", "", 0);
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

    private GameEngineCallbackGUI gameEngineCallbackGUI;
    private GameEngine gameEngine;

    private GroupLayout groupLayout;
    /**
     * Main Constructor, take two GameEngineCallback
     * @see GameEngineCallbackGUI
     * @see view.GameEngineCallbackImpl
     */

    public PlayerEditorPanel(GameEngineCallbackGUI gameEngineCallbackGUI, GameEngine gameEngine){
        groupLayout = new GroupLayout(this);
        setLayout(groupLayout);
        this.gameEngine = gameEngine;
        this.gameEngineCallbackGUI = gameEngineCallbackGUI;


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

        /**
         * When this button is clicked, a player will be edited (if the input is valid)
         */
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
                        updatePlayer(selectedPlayer, newPlayer);
                        gameEngineCallbackGUI.refreshSummaryPanel();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error in Input");
                }

            }
        });
        /**
         * When this button is clicked,all changes are reversed
         */
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                playerNameTextfield.setText(selectedPlayer.getPlayerName());
                playerBetpointTextfield.setText(String.valueOf(selectedPlayer.getBet()));
                box.setSelectedItem(selectedPlayer.getBetType());
            }
        });
        /**
         * When this button is clicked, a player will be removed, a dialog will be shown to confirm the change
         */
        destroyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int n = JOptionPane.showConfirmDialog(
                        null,
                        "Would you like to delete this player",
                        "Need confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.OK_OPTION){
                    gameEngineCallbackGUI.removePlayer(selectedPlayer);
                    gameEngineCallbackGUI.refreshSummaryPanel();
                    gameEngineCallbackGUI.refreshPlayerSelectionPane();
                    resetTextArea();
                }

            }
        });

    }
    /**
     * Method to show the component
     */
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
    /**
     * Method to set which player is being edited
     */
    public void setSelectedPlayer(Player player){
        this.selectedPlayer = player;
        populate(groupLayout);
    }
    /**
     * Method to update player
     */
    private void updatePlayer(Player oldPlayer, Player newPlayer){
        oldPlayer.setPlayerName(newPlayer.getPlayerName());
        oldPlayer.setBet(newPlayer.getBet());
        oldPlayer.setBetType(newPlayer.getBetType());

        boolean flag = true;
        for (Player player : gameEngineCallbackGUI.getPlayers()){
            if (player.getBet() == 0){
                flag = false;
                break;
            }
        }
        /**
         * After any player is edited successfully, if everyone has a bet, do the spin
         */
        if (flag){
            gameEngine.spin(1, 200, 4);
        }
    }

    /**
     * Reset the text area and panel
     */
    private void resetTextArea(){
        playerNameTextfield.setText("");
        playerBetpointTextfield.setText("");
    }
    public void refreshEditorPanel(){
        playerNameTextfield.setText("");
        playerBetpointTextfield.setText("");
    }
}
