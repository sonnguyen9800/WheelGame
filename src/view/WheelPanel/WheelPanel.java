package view.WheelPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static view.WheelGameUI.WHEELGAME_WIDTH;

public class WheelPanel extends JPanel {
    private BufferedImage image;
    private Image backGroundImage;

    public WheelPanel() {
        try {
            image = ImageIO.read(new File("img/wheel_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(WHEELGAME_WIDTH/3, WHEELGAME_WIDTH/3);
        backGroundImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backGroundImage, 0, 0, this);
    }

}
