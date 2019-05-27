package view.WheelPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static view.WheelGameUI.WHEELGAME_WIDTH;

public class WheelPanel extends JPanel implements MouseListener {
    private BufferedImage image;
    private Image backGroundImage;
    int time = 1;

    public WheelPanel() {
        try {
            image = ImageIO.read(new File("img/wheel_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(400, 400);
        setPreferredSize(new Dimension(400, 400));
        System.out.println(this.getWidth() + " " + this.getHeight());
        backGroundImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
//        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton jButton = new JButton("Click Me");
        jButton.addMouseListener(this);
        add(jButton);

        addMouseListener(this);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        backGroundImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
        g.drawImage(backGroundImage, 0, 0, this);

//        System.out.println("MAX X: " + this.getHeight());
//        System.out.println("MAX Y: " + this.getWidth());
        Graphics2D g2d = (Graphics2D)g;

        g2d.setPaint(new Color(243, 255, 53));
        int trueWidth = this.getWidth();
        int trueHeight = this.getHeight()-6;
        double x = trueWidth/2 - 20 + (trueWidth/2)*Math.cos(0.16528268*time) ;
        double y = trueHeight/2 + (trueHeight/2)*Math.sin(0.16528268*time) ;

        int sizeOval = 20;
        System.out.println("Location of Ball: " + (int)x + ":"+ (int)y);
        System.out.println("True Width: " + trueWidth + ":"+ trueHeight);

//        g2d.fillOval(this.getWidth()/2 - sizeOval/2,this.getHeight()/2 - sizeOval/2,
//                sizeOval, sizeOval);
        g2d.fillOval((int)x,(int)y,
                sizeOval, sizeOval);

        g2d.setBackground(Color.RED);
    }

    protected void paintMovingBall(){
        this.repaint();
        System.out.println();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        this.paintMovingBall();
        time+=1;
        System.out.println("Location Mouse Clicked: " + mouseEvent.getX() + ":" + mouseEvent.getY());
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
}
