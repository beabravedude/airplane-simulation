package animation.model;

import animation.Animatable;

import java.awt.*;

public class Airplane implements Animatable {

    private static final double TAKEOFF_ACCELERATION = 2.3;
    private static final double TAKEOFF_TARGET_SPEED = 140.0/100;

    private static final double LANDING_SPEED = 150;

    private static double SPEED = 0;
    private static final double MASS = 77000/100000D;
    private static final int TAKEOFF_ANGLE = 20;

    private static final int CRUISE_ALTITUDE = 700;
    private int x;

    private int y;

    public Airplane(int frameWidth, int frameHeight) {
        this.x = frameWidth - 70;
        this.y = frameHeight - 60;
    }

    @Override
    public void render(Graphics g, int frameWidth, int frameHeight, double time, double speed) {
        g.setColor(Color.RED);
        g.fillOval(x, y - 20, 50, 20);


        if (y > frameHeight - 100) {
            g.setColor(Color.BLACK);
            g.fillOval(x + 30, y, 10, 10);
            g.fillOval(x + 10, y, 10, 10);
        }


        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Altitude: " + (frameHeight - y), 10, 20);
        g.drawString("Distance: " + (frameWidth - x), 10, 40);
        g.drawString("Speed: " + SPEED, 10, 60);
        g.drawString("Time: " + time, 10, 80);
        g.drawString("Phase: " + getPhaseOfFlight(frameWidth, frameHeight), 10, 100);

    }

    @Override
    public void move(double speed, int frameWidth, int frameHeight) {
        switch (getPhaseOfFlight(frameWidth, frameHeight)) {
            case "Takeoff":
                takeoff(speed);
                break;
            case "Climb":
                climb();
                break;
            case "Cruise":
                cruise();
                break;
            case "Descent":
                descent();
                break;
            case "Landing":
                landing(frameHeight);
                break;
        }
    }

    private void takeoff(double speed) {
        SPEED += TAKEOFF_ACCELERATION * MASS * speed;
        if (SPEED >= TAKEOFF_TARGET_SPEED) {
            y -= (int) (SPEED * Math.sin(Math.toRadians(TAKEOFF_ANGLE))/50);
            x -= (int) (SPEED * Math.cos(Math.toRadians(TAKEOFF_ANGLE))/100);
        } else {
            x -= (int) SPEED/100;
        }
    }

    private void cruise() {
        x -= (int) (SPEED * Math.cos(Math.toRadians(0))/100);
    }

    private void descent() {
        y += (int) (SPEED * Math.sin(Math.toRadians(2))/10);
        x -= (int) (SPEED * Math.cos(Math.toRadians(2))/100);
    }

    private void landing(int frameHeight) {
        if (SPEED > LANDING_SPEED) {
            SPEED -= 2;
        }
        if (y >= frameHeight - 60) {
            if (SPEED > 0) {
                SPEED -= 2;
            }
            y = frameHeight - 60;
        } else {
            int descend = (int) (SPEED * Math.sin(Math.toRadians(7)) / 18);
            y += descend;
        }
        if (x < 50) {
            SPEED = 0;
            x = 50;
        } else {
            x -= (int) (SPEED * Math.cos(Math.toRadians(7))/100);
        }
    }

    private void climb() {
        y -= (int) (SPEED * Math.sin(Math.toRadians(15))/50);
        x -= (int) (SPEED * Math.cos(Math.toRadians(15))/100);
    }

    private String getPhaseOfFlight(int frameWidth, int frameHeight) {
        String phase = "Climb";
        if (y <= CRUISE_ALTITUDE - 100) {
            phase = "Cruise";
        }
        if (y > frameHeight - 150 && x > frameWidth/2) {
            phase = "Takeoff";
        }
        if (y > frameHeight - 150 && x < frameWidth/2) {
            phase = "Landing";
        }
        if (y <= frameHeight - 150 && x < frameWidth/3.5) {
            phase = "Descent";
        }

        return phase;
    }

}
