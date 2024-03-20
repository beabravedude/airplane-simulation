package animation;

import java.awt.*;

public interface Animatable {

    void render(Graphics g, int frameWidth, int frameHeight);

    void move();

}
