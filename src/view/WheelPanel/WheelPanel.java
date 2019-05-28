package view.WheelPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WheelPanel extends JPanel implements MouseListener {

    private BufferedImage image;
    private Image backGroundImage;
    int time = 0;

    public WheelPanel() {
        try {
            image = ImageIO.read(new File("img/wheel_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(400, 400);
        setPreferredSize(new Dimension(400, 400));
        System.out.println(this.getWidth() + " " + this.getHeight());

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addMouseListener(this);
    }

    private void setTime(int time){
        this.time = time;
    }

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


    private void paintBall(Graphics g, int width, int scaleWidth, int scaleHeight, int x, int y, int time){
        Graphics2D g2d = (Graphics2D)g;
        int sizeOval = width/30;
        g2d.setPaint(new Color(243, 255, 53));

        double rad = Math.PI/2 - (Math.PI*time)/19;

        int ballX = x + scaleWidth/2 - sizeOval/2 + (int)((scaleWidth/2)*Math.cos(rad));
        int ballY = y + scaleHeight/2 - (int)((scaleHeight/2)*Math.sin(rad)) - sizeOval/2;
        g2d.fillOval(ballX,ballY, sizeOval, sizeOval);
    }


    public void paintMovingBall(int timeInput){
        setTime(timeInput);
        this.repaint();
        System.out.println();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }


    public double getScaleFactorToFit(Dimension original, Dimension toFit) {

        double dScale = 1d;

        if (original != null && toFit != null) {

            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);

            dScale = Math.min(dScaleHeight, dScaleWidth);

        }

        return dScale;
    }
    public double getScaleFactor(int iMasterSize, int iTargetSize) {

        double dScale = 1;
        if (iMasterSize > iTargetSize) {

            dScale = (double) iTargetSize / (double) iMasterSize;

        } else {

            dScale = (double) iTargetSize / (double) iMasterSize;

        }

        return dScale;

    }
}


