package view.Menu;


import view.GameEngineCallbackGUI;

import javax.swing.*;

public class WheelMenuBar extends JMenuBar {
    public WheelMenuBar(JFrame jFrame, GameEngineCallbackGUI gameEngineCallbackGUI){
        add(new MenuItemPlayer(jFrame, gameEngineCallbackGUI));
        add(new MenuItemOptions());


        setFocusable(true);
        setVisible(true);
    }
}
