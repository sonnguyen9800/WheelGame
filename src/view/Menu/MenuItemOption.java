package view.Menu;

import javax.swing.*;
import java.awt.*;

public class MenuItemOption extends JMenu {
    public MenuItemOption(){
        super("Option");
        addItemToOptionMenu();
    }

    public void addItemToOptionMenu(){
        JMenuItem addPlayer = new JMenuItem();
        addPlayer.setText("Add Player");
        JMenuItem removePlayer = new JMenuItem();
        removePlayer.setText("Remove Player");

        this.add(addPlayer);
        this.add(removePlayer);
    }
}
