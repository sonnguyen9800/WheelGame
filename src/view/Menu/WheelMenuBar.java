package view.Menu;


import javax.swing.*;

public class WheelMenuBar extends JMenuBar {
    public WheelMenuBar(JFrame jFrame){
        add(new MenuItemPlayer(jFrame));
        add(new MenuItemOptions());


        setFocusable(true);
        setVisible(true);
    }
}
