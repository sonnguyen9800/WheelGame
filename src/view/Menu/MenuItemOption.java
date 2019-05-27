package view.Menu;

import controller.MenuItemActionListener;

import javax.swing.*;

public class MenuItemOption extends JMenu {
    JFrame jFrame;
    MenuItemActionListener menuItemActionListener;
    public MenuItemOption(JFrame jFrame){
        super("Option");
        this.jFrame = jFrame;
        this.menuItemActionListener = new MenuItemActionListener(jFrame);

        addItemToOptionMenu();
    }

    public void addItemToOptionMenu(){
        JMenuItem addPlayer = new JMenuItem();
        addPlayer.setText("Add Player");

        addPlayer.addActionListener(menuItemActionListener);

        JMenuItem removePlayer = new JMenuItem();
        removePlayer.setText("Remove Player");
        removePlayer.addActionListener(menuItemActionListener);



        this.add(addPlayer);
        this.add(removePlayer);
    }
}
