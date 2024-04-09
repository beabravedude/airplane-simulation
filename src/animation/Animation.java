package animation;

import animation.model.Airplane;
import animation.model.Background;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation implements ActionListener {

    private final Graphics g;
    private final Runnable afterRender;
    private final int frameWidth;
    private final int frameHeight;

    private final double speed;

    private double time = 1;

    private final Background background;

    private final Airplane airplane;

    public Animation(Graphics g, int frameWidth, int frameHeight, double speed, Runnable afterRender) {
        this.g = g;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.speed = speed;
        this.afterRender = afterRender;

        this.background = new Background();
        this.airplane = new Airplane(frameWidth, frameHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        background.render(g, frameWidth, frameHeight, this.time, this.speed);
        airplane.render(g, frameWidth, frameHeight, this.time, this.speed);
        background.move(speed, frameWidth, frameHeight);
        airplane.move(speed, this.frameWidth, this.frameHeight);
        this.time += this.speed;
        afterRender.run();
    }
}
