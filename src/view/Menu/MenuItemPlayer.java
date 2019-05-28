package view.Menu;

import controller.MenuItemActionListener;
import view.GameEngineCallbackGUI;

import javax.swing.*;

public class MenuItemPlayer extends JMenu {
    JFrame jFrame;
    MenuItemActionListener menuItemActionListener;
    private JMenuItem addPlayer;


    public MenuItemPlayer(JFrame jFrame) {
        super("Add Player");
        this.jFrame = jFrame;
        this.menuItemActionListener = new MenuItemActionListener(jFrame);

        addPlayer = new JMenuItem();
        addPlayer.addActionListener(menuItemActionListener);
        addPlayer.setText("Create a new Player");
        add(addPlayer);
    }

}
