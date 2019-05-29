package view.Menu;

import javax.swing.*;

public class MenuItemOptions extends JMenu {
    private JMenuItem helpMenuItem;
    private JMenuItem restartMenuItem;
    private JMenuItem quitGameMenuItem;
    private JMenuItem aboutMenuItem;
    public MenuItemOptions(){
        super("New Game");

        helpMenuItem = new JMenuItem("Help");
        restartMenuItem = new JMenuItem( "Restart");
        aboutMenuItem = new JMenuItem("About");
        quitGameMenuItem = new JMenuItem("Quit");

        add(helpMenuItem);
        add(restartMenuItem);
        add(aboutMenuItem);
        add(quitGameMenuItem);
    }
}
