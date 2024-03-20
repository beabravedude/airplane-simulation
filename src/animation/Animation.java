package animation;

import animation.model.Airplane;
import animation.model.Background;
import animation.model.DataDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
        this.airplane = new Airplane();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        background.render(g, frameWidth, frameHeight);
        airplane.render(g, frameWidth, frameHeight);
        airplane.move();
        Animatable dataDisplay = new DataDisplay(10000, 500, (int) this.time);
        dataDisplay.render(g, frameWidth, frameHeight);
        this.time += this.speed;
        afterRender.run();
    }
}
