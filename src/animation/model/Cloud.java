package animation.model;

import animation.Animatable;

import java.awt.*;

// cloud object
public class Cloud implements Animatable {

    private final double velocity;
    private double x;
    private final double y;
    private final boolean reverse;

    public Cloud(int initialX, int initialY, boolean reverse) {
        // generate a random velocity as well as save the initial position.
        this.velocity = Math.random();
        this.x = initialX;
        this.y = initialY;
        this.reverse = reverse;
    }

    @Override
    public void render(Graphics g, int frameWidth, int frameHeight, double time, double speed) {
        // draw the cloud oval
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, 100, 60);
    }

    @Override
    public void move(double speed, int frameWidth, int frameHeight) {
        // move the cloud based on the velocity and direction (reverse will move to the left)
        if (reverse) {
            x -= velocity;
        } else {
            x += velocity;
        }
    }
}
