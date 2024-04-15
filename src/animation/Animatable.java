package animation;

import java.awt.*;

/**
 * Interface for objects that can be animated
 */
public interface Animatable {

    /**
     * Render the object
     * @param g Graphics object
     * @param frameWidth frame width
     * @param frameHeight frame height
     * @param time time
     * @param speed speed
     */
    void render(Graphics g, int frameWidth, int frameHeight, double time, double speed);

    /**
     * Move the object (called each iteration of the animation)
     * @param speed speed
     * @param frameWidth frame width
     * @param frameHeight frame height
     */
    void move(double speed, int frameWidth, int frameHeight);

}
