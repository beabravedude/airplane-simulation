package animation.model;

import animation.Animatable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Background implements Animatable {
    private final List<Cloud> clouds = new ArrayList<>();

    @Override
    public void render(Graphics g, int frameWidth, int frameHeight, double time, double speed) {

        // draw the sky as a gradient
        for (int i = 0; i < frameHeight; i++) {
            g.setColor(new Color(0, 255, 255 - i / 10));
            g.drawLine(0, i, frameWidth, i);
        }

        // draw the sun
        g.setColor(Color.YELLOW);
        g.fillOval(frameWidth - 100, 10, 100, 80);

        // calculate could height from the top of the frame
        int cloudTopOffset = frameHeight / 25;

        // if there are no clouds, add some
        if (clouds.isEmpty()) {
            clouds.addAll(List.of(
                    new Cloud(0, cloudTopOffset, false),
                    new Cloud(10, cloudTopOffset - 10, false),
                    new Cloud(120, cloudTopOffset + 50, false),
                    new Cloud(frameWidth - 100, cloudTopOffset, true),
                    new Cloud(frameWidth - 200, cloudTopOffset - 20, true),
                    new Cloud(frameWidth / 2, cloudTopOffset + 60, true),
                    new Cloud(frameWidth / 2 - 20, cloudTopOffset + 30, true)
            ));
        }

        // render each cloud
        clouds.forEach(cloud -> cloud.render(g, frameWidth, frameHeight, time, speed));

        // draw the ground
        g.setColor(new Color(0,100,0));
        g.fillRect(0, frameHeight - 50, frameWidth, 100);
        // draw some trees
        g.setColor(new Color(139,69,19));
        g.fillRect(450, frameHeight - 100, 20, 50);
        g.fillRect(850, frameHeight - 100, 20, 50);
        g.fillRect(1050, frameHeight - 100, 20, 50);
        // draw some leaves on the trees
        g.setColor(Color.GREEN);
        g.fillOval(435, frameHeight - 140, 50, 50);
        g.fillOval(835, frameHeight - 140, 50, 50);
        g.fillOval(1035, frameHeight - 140, 50, 50);


        // draw the runways
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, frameHeight - 50, 200, 100);
        g.fillRect(frameWidth - 200, frameHeight - 50, 200, 100);

        // draw runway center lines for both of them
        g.setColor(Color.WHITE);
        g.fillRect(25, frameHeight - 25, 50, 5);
        g.fillRect(125, frameHeight - 25, 50, 5);

        g.fillRect(frameWidth - 100, frameHeight - 25, 50, 5);
        g.fillRect(frameWidth - 175, frameHeight - 25, 50, 5);

        // draw the control tower
        g.setColor(Color.DARK_GRAY);
        g.fillRect(frameWidth - 200, frameHeight - 200, 50, 150);
        g.fillRect(frameWidth - 225, frameHeight - 200, 100, 50);

        // draw the windows on the control tower
        g.setColor(Color.WHITE);
        g.fillRect(frameWidth - 190, frameHeight - 190, 10, 10);
        g.fillRect(frameWidth - 190, frameHeight - 170, 10, 10);
        g.fillRect(frameWidth - 170, frameHeight - 190, 10, 10);
        g.fillRect(frameWidth - 170, frameHeight - 170, 10, 10);


    }

    @Override
    public void move(double speed, int frameWidth, int frameHeight) {
        // move each cloud
        clouds.forEach(cloud -> cloud.move(speed, frameWidth, frameHeight));
    }


}
