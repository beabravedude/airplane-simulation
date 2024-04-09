package animation.model;

import animation.Animatable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Background implements Animatable {


    private int CLOUD_POSITION = 0;

    private final List<Cloud> clouds = new ArrayList<>();

    @Override
    public void render(Graphics g, int frameWidth, int frameHeight, double time, double speed) {

        CLOUD_POSITION += (int) (Math.random() * 2);

        for (int i = 0; i < frameHeight; i++) {
            g.setColor(new Color(0, 255, 255 - i / 10));
            g.drawLine(0, i, frameWidth, i);
        }
        g.setColor(Color.YELLOW);
        g.fillOval(frameWidth - 100, 10, 100, 80);

        int cloudTopOffset = frameHeight / 25;

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

        clouds.forEach(cloud -> cloud.render(g, frameWidth, frameHeight, time, speed));

        g.setColor(new Color(0,100,0));
        g.fillRect(0, frameHeight - 50, frameWidth, 100);
        g.setColor(new Color(139,69,19));
        g.fillRect(450, frameHeight - 100, 20, 50);
        g.fillRect(850, frameHeight - 100, 20, 50);
        g.fillRect(1050, frameHeight - 100, 20, 50);
        // draw some leaves on the trees
        g.setColor(Color.GREEN);
        g.fillOval(435, frameHeight - 140, 50, 50);
        g.fillOval(835, frameHeight - 140, 50, 50);
        g.fillOval(1035, frameHeight - 140, 50, 50);


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
    public void move(double speed, int frameWidth, int frameHeight) {
        clouds.forEach(cloud -> cloud.move(speed, frameWidth, frameHeight));
    }


}
