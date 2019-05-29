package view.Menu;

import controller.MenuItemActionListener;
import view.GameEngineCallbackGUI;

import javax.swing.*;

/**
 * This menu leads to create new Dialog used to add new player
 *
 * @see MenuItemActionListener
 * @see view.Dialog.PlayerNewDialog
 */
public class MenuItemPlayer extends JMenu {
    JFrame jFrame;
    MenuItemActionListener menuItemActionListener;
    private JMenuItem addPlayer;
    private GameEngineCallbackGUI gameEngineCallbackGUI;


    public MenuItemPlayer(JFrame jFrame, GameEngineCallbackGUI gameEngineCallbackGUI) {
        super("Add Player");
        this.jFrame = jFrame;

        this.gameEngineCallbackGUI = gameEngineCallbackGUI;
        this.menuItemActionListener = new MenuItemActionListener(jFrame, gameEngineCallbackGUI);

        addPlayer = new JMenuItem();
        addPlayer.addActionListener(menuItemActionListener);
        addPlayer.setText("Create a new Player");
        add(addPlayer);
    }

}
