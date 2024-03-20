package animation.model;

import animation.Animatable;

import java.awt.*;

public class Background implements Animatable {
    @Override
    public void render(Graphics g, int frameWidth, int frameHeight) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, frameWidth, frameHeight);
        int cloudTopOffset = frameHeight / 25;
        g.setColor(Color.WHITE);
        g.fillOval(10, cloudTopOffset, 100, 60);
        g.fillOval(60, cloudTopOffset+30, 100, 60);
        g.fillOval(frameWidth - 110, cloudTopOffset, 100, 60);
        g.fillOval(frameWidth - 160, cloudTopOffset+30, 100, 60);

        g.setColor(Color.GREEN);
        g.fillRect(0, frameHeight - 50, frameWidth, 100);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, frameHeight - 50, 200, 100);
        g.fillRect(frameWidth - 200, frameHeight - 50, 200, 100);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(frameWidth - 200, frameHeight - 200, 50, 150);
        g.fillRect(frameWidth - 225, frameHeight - 200, 100, 50);

        g.setColor(Color.WHITE);
        g.fillRect(frameWidth - 190, frameHeight - 190, 10, 10);
        g.fillRect(frameWidth - 190, frameHeight - 170, 10, 10);
        g.fillRect(frameWidth - 170, frameHeight - 190, 10, 10);
        g.fillRect(frameWidth - 170, frameHeight - 170, 10, 10);


    }

    @Override
    public void move() {

    }
}
