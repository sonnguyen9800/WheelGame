package view.Menu;


import view.GameEngineCallbackGUI;

import javax.swing.*;
/**
 * This WheelBar showing some options for the game
 *
 * There are two menus:
 * 1) MenuItemPlayer - used to create new Player
 * @see MenuItemPlayer
 * 2) MenuItemOptions - used to do something special
 * @see MenuItemOptions
 *
 */
public class WheelMenuBar extends JMenuBar {
    public WheelMenuBar(JFrame jFrame, GameEngineCallbackGUI gameEngineCallbackGUI){
        add(new MenuItemPlayer(jFrame, gameEngineCallbackGUI));
        add(new MenuItemOptions());


        setFocusable(true);
        setVisible(true);
    }
}
