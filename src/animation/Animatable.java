package animation;

import java.awt.*;

public interface Animatable {

    void render(Graphics g, int frameWidth, int frameHeight, double time, double speed);

    void move(double speed, int frameWidth, int frameHeight);

}
