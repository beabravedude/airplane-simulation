import animation.Animator;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // standard JFrame setup
        JFrame frame = new JFrame("Airplane Simulation");
        frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add the animator to the frame
        frame.setContentPane(new Animator(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT, Constants.SIMULATION_SPEED));
        frame.setVisible(true);
    }
}