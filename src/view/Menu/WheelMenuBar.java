package view.Menu;

import javax.swing.*;

public class WheelMenuBar extends JMenuBar {
    public WheelMenuBar(){
        add(new MenuItemOption());
        add(new MenuItemNewGame());
        add(new MenuItemRestart());
        add(new MenuItemHelp());
    }
}
