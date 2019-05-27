package view.Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
 
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
 
public class ResizeImage extends JPanel {
 
    private static final long serialVersionUID = 7210857306625744220L;
    private Image mainImage = null;
    private Image scaledImage = null;
    private URL path = null;
    private JDialog browser = null;
 
    public ResizeImage(int width, int height) {
        this.setBackground(Color.lightGray);
        this.setPreferredSize(new Dimension(width, height));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 
        browser = new JDialog((JFrame) this.getParent(), "My future robot");
        browser.setModalityType(ModalityType.APPLICATION_MODAL);

 
        try {

            mainImage = ImageIO.read(new File("img/wheel_image.png"));
            mainImage = mainImage.getScaledInstance(
                    this.getPreferredSize().width,
                    this.getPreferredSize().height, Image.SCALE_REPLICATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                scaledImage = mainImage.getScaledInstance(
                        ResizeImage.this.getWidth(),
                        ResizeImage.this.getHeight(), Image.SCALE_REPLICATE);
                ResizeImage.this.repaint();
                super.componentResized(e);
            }
        });
 
        addMouseMotionListener(new MouseMotionAdapter() {
 
            public void mouseMoved(MouseEvent e) {
                if (e.getY() == 0) {
                    setMyCursor(Cursor.N_RESIZE_CURSOR);
                } else if (e.getX() == 0) {
                    setMyCursor(Cursor.W_RESIZE_CURSOR);
                } else if (e.getX() == ResizeImage.this.getWidth()) {
                    setMyCursor(Cursor.E_RESIZE_CURSOR);
                } else if (e.getY() == ResizeImage.this.getHeight()) {
                    setMyCursor(Cursor.S_RESIZE_CURSOR);
                }
            }
        });
 
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    browser.setVisible(true);
                }
            }
        });
    }
 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // to prevent this method to apply g2d features from preceding methods
        g2d = (Graphics2D) g2d.create();
        // g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
        // RenderingHints.VALUE_RENDER_QUALITY);
        // g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        // RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (scaledImage == null)
            //this way is not possible if you use MVC where your image is represented by your own class in model
//          g2d.drawImage(mainImage, 0, 0, this.getWidth(), this.getHeight(),
//                  Color.white, this);
            g2d.drawImage(mainImage, 0, 0, this);
        else {
            g2d.drawImage(scaledImage, 0, 0, this);
//          g2d.drawImage(scaledImage, 0, 0, this.getWidth(), this.getHeight(),
//                  Color.white, this);
        }
        // to prevent next methods of g2d to use features set to g2d here
        g2d.dispose();
    }
 
    public void setMyCursor(int cursor) {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
 
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ResizeImage(600, 600));
        frame.pack();
        frame.setVisible(true);
 
    }
}