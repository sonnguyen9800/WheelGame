package view.Menu;

import javax.swing.*;

public class WheelMenuBar extends JMenuBar {
    public WheelMenuBar(JFrame jFrame){
        add(new MenuItemOption(jFrame));
        add(new MenuItemNewGame());
        add(new MenuItemRestart());
        add(new MenuItemHelp());
    }
}
