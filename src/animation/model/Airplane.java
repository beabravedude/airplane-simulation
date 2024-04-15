package animation.model;

import animation.Animatable;

import java.awt.*;

// airplane object
public class Airplane implements Animatable {

    // derived from actual airplane data
    private static final double TAKEOFF_ACCELERATION = 2.3;

    // derived from actual airplane data
    private static final double TAKEOFF_TARGET_SPEED = 140.0/100;

    // derived from actual airplane data
    private static final double LANDING_SPEED = 150;

    private static double SPEED = 0;

    // derived from actual airplane data
    private static final double MASS = 77000/100000D;

    // derived from actual airplane data
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
        // draw the airplane with wings and a tail
        g.setColor(Color.RED);
        g.fillOval(x, y - 20, 50, 20);
        g.setColor(Color.WHITE);
        g.fillOval(x+10, y-10, 30, 5);
        g.setColor(Color.BLUE);
        g.fillPolygon(new int[]{x+35, x + 50, x + 50}, new int[]{y - 10, y - 10, y - 30}, 3);


        // draw the landing gear if the airplane is close to the ground
        if (y > frameHeight - 100) {
            g.setColor(Color.BLACK);
            g.fillOval(x + 30, y, 10, 10);
            g.fillOval(x + 10, y, 10, 10);
        }


        // draw the altitude, distance, speed, time, and phase of flight using text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Altitude: " + (frameHeight - y), 10, 20);
        g.drawString("Distance: " + (frameWidth - x), 10, 40);
        g.drawString("Speed: " + String.format("%.2f", SPEED), 10, 60);
        g.drawString("Time: " + time, 10, 80);
        g.drawString("Phase: " + getPhaseOfFlight(frameWidth, frameHeight), 10, 100);

    }

    @Override
    public void move(double speed, int frameWidth, int frameHeight) {
        // move the airplane based on the phase of flight
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
        // accelerate the airplane to the target speed and then take off
        SPEED += TAKEOFF_ACCELERATION * MASS * speed;
        // if the speed is greater than the target speed, take off
        if (SPEED >= TAKEOFF_TARGET_SPEED) {
            // move the airplane up at takeoff angle and accelerate forward
            y -= (int) (SPEED * Math.sin(Math.toRadians(TAKEOFF_ANGLE))/50);
            x -= (int) (SPEED * Math.cos(Math.toRadians(TAKEOFF_ANGLE))/100);
        } else {
            x -= (int) SPEED/100;
        }
    }

    private void cruise() {
        // move the airplane forward at a constant speed
        x -= (int) (SPEED * Math.cos(Math.toRadians(0))/100);
    }

    private void descent() {
        // move the airplane down at a slight angle and forward
        y += (int) (SPEED * Math.sin(Math.toRadians(2))/10);
        x -= (int) (SPEED * Math.cos(Math.toRadians(2))/100);
    }

    private void landing(int frameHeight) {
        // slow down the airplane using realistic speed break data until at a safe landing speed
        if (SPEED > LANDING_SPEED) {
            SPEED -= 2;
        }
        // if the airplane is close to the ground, land and stop descending
        if (y >= frameHeight - 60) {
            if (SPEED > 0) {
                SPEED -= 2;
            }
            y = frameHeight - 60;
        } else {
            // descend the airplane down at a slight angle and forward
            int descend = (int) (SPEED * Math.sin(Math.toRadians(7)) / 18);
            y += descend;
        }
        // if the airplane is at the end of the runway, stop
        if (x < 50) {
            SPEED = 0;
            x = 50;
        } else {
            // slow the airplane down as it lands
            x -= (int) (SPEED * Math.cos(Math.toRadians(7))/100);
        }
    }

    private void climb() {
        // move the airplane up and move forward
        y -= (int) (SPEED * Math.sin(Math.toRadians(15))/50);
        x -= (int) (SPEED * Math.cos(Math.toRadians(15))/100);
    }

    private String getPhaseOfFlight(int frameWidth, int frameHeight) {
        // determine the phase of flight based on the airplane's position
        String phase = "Climb";
        // if the airplane is at cruise altitude, it is in cruise phase
        if (y <= CRUISE_ALTITUDE - 100) {
            phase = "Cruise";
        }
        // if the airplane is close to the ground and on the right side of the screen, it is in takeoff phase
        if (y > frameHeight - 150 && x > frameWidth/2) {
            phase = "Takeoff";
        }
        // if the airplane is close to the ground and on the left side of the screen, it is in landing phase
        if (y > frameHeight - 150 && x < frameWidth/2) {
            phase = "Landing";
        }
        // if the airplane is close to the ground and in the middle of the screen, it is in descent phase
        if (y <= frameHeight - 150 && x < frameWidth/3.5) {
            phase = "Descent";
        }

        // else, the airplane is in climb phase
        return phase;
    }

}
