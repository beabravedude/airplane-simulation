package animation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.invoke.ConstantCallSite;

// runs the actual timer for the animation
public class Animator extends JPanel {

    private final Image image;

    public Animator(int frameWidth, int frameHeight, double speed) {

        // create a new image to draw on
        this.image = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = this.image.getGraphics();

        // create a timer that will call the animation every 10 milliseconds
        // the animation will then render the airplane and background and move them accordingly
        // the repaint method will then be called to update the screen after each iteration
        Timer timer = new Timer(10, new Animation(g, frameWidth, frameHeight, speed, this::repaint));
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}
