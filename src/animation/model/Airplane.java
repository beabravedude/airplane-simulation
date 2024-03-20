package animation.model;

import animation.Animatable;

import java.awt.*;

public class Airplane implements Animatable {

    private int dx = 0;
    @Override
    public void render(Graphics g, int frameWidth, int frameHeight) {
        g.setColor(Color.RED);
        // draw the airplane body very SMALL on the far right runway
        g.fillOval(frameWidth - 70 - dx, frameHeight - 80, 50, 20);

        g.setColor(Color.BLACK);
        g.fillOval(frameWidth - 40 - dx, frameHeight - 60, 10, 10);
        g.fillOval(frameWidth - 60 - dx, frameHeight - 60, 10, 10);



    }

    @Override
    public void move() {
        dx += 1;
    }

}
