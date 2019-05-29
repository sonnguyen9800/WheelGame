package view.WheelPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * This Panel Show the WheelImage
 * This panel also takes responsibility to update and create the animation of the ball
 * @see view.GameEngineCallbackGUI
 */
public class WheelPanel extends JPanel  {

    private BufferedImage image;
    private int time = 0;

    public WheelPanel() {
        try {
            image = ImageIO.read(new File("img/wheel_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(400, 400);
        setPreferredSize(new Dimension(400, 400));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setTime(int time){
        this.time = time;
    }
    /**
     * The Paint Method - Create the image of the Wheel and the Ball
     *
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        double scaleFactor = Math.min(1d, getScaleFactorToFit(new Dimension(image.getWidth(), image.getHeight()), getSize()));

        //TRUE WIDTH AND HEIGHT
        int scaleWidth = (int) Math.round(image.getWidth() * scaleFactor);
        int scaleHeight = (int) Math.round(image.getHeight() * scaleFactor);
        Image scaled = image.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);

        int width = getWidth() - 1;
        int height = getHeight() - 1;
        int x = (width - scaled.getWidth(this)) / 2;
        int y = (height - scaled.getHeight(this)) / 2;
        g.drawImage(scaled, x, y, this);

        paintBall(g, width, scaleWidth, scaleHeight, x, y, time);
    }

    /**
     * The Paint Method - Create the image of the the Ball based on current location of the wheel
     *
     */
    private void paintBall(Graphics g, int width, int scaleWidth, int scaleHeight, int x, int y, int time){
        try {
            image = ImageIO.read(new File("img/wheel_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D g2d = (Graphics2D)g;
        int sizeOval = width/30;
        g2d.setPaint(new Color(243, 255, 53));

        double rad = Math.PI/2 - (Math.PI*time)/19;

        int ballX = x + scaleWidth/2 - sizeOval/2 + (int)((scaleWidth/2)*Math.cos(rad));
        int ballY = y + scaleHeight/2 - (int)((scaleHeight/2)*Math.sin(rad)) - sizeOval/2;
        g2d.fillOval(ballX,ballY, sizeOval, sizeOval);
    }
    /**
     * Call this method from outside to update the WheelPanel
     * the timeInput parameter is used to choose the position of the ball
     * @param timeInput
     *
     */

    public void paintMovingBall(int timeInput){
        removeAll();
        setTime(timeInput);
        repaint();
    }


    /**
     * These two methods are used to automatically resize the wheelpanel and the ball
     *
     */
    private double getScaleFactorToFit(Dimension original, Dimension toFit) {

        double dScale = 1d;

        if (original != null && toFit != null) {

            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);

            dScale = Math.min(dScaleHeight, dScaleWidth);

        }

        return dScale;
    }
    private double getScaleFactor(int iMasterSize, int iTargetSize) {

        double dScale;
        if (iMasterSize > iTargetSize) {

            dScale = (double) iTargetSize / (double) iMasterSize;

        } else {

            dScale = (double) iTargetSize / (double) iMasterSize;

        }

        return dScale;

    }
}


