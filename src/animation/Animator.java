package animation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.invoke.ConstantCallSite;

public class Animator extends JPanel {

    private final Image image;

    public Animator(int frameWidth, int frameHeight, double speed) {

        this.image = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = this.image.getGraphics();

        Timer timer = new Timer(10, new Animation(g, frameWidth, frameHeight, speed, this::repaint));
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}
