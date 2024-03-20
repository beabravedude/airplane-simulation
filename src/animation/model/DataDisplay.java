package animation.model;

import animation.Animatable;

import java.awt.*;

public class DataDisplay implements Animatable {

    private final int altitude;
    private final int speed;
    private final int time;

    public DataDisplay(int altitude, int airspeed, int time) {
        this.altitude = altitude;
        this.speed = airspeed;
        this.time = time;
    }

    @Override
    public void render(Graphics g, int frameWidth, int frameHeight) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Altitude: " + altitude, 10, 20);
        g.drawString("Speed: " + speed, 10, 40);
        g.drawString("Time: " + time, 10, 60);
    }

    @Override
    public void move() {

    }
}
