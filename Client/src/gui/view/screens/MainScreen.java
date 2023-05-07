package gui.view.screens;

import gui.utils.FrameUtility.FrameDragListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
public class MainScreen {
    final int frameWidth = 1000;
    final int frameHeight = 600;
    private static JFrame frame;
    private static Image mainIcon;

    public MainScreen() throws IOException {

        frame = new JFrame();

        mainIcon = ImageIO.read(getClass().getResource("/gui/res/loginImage.png"));

        frame.setIconImage(mainIcon);

        // Sets the default operation when the exit button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets layout to null to allow free placement
        frame.setLayout(null);

        frame.setBackground(null);
        // Calls Creat Panel Function to create and add base panel

        // Removes title bar, rounds the edge of the frame and sets default size
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, frameWidth, frameHeight, 30, 30));
        frame.setSize(frameWidth, frameHeight);
        frame.setTitle("Home & Away Institute");
        // sets location of the frame to the center of the screen
        frame.setLocationRelativeTo(null);
        // makes frame visible
        frame.setVisible(true);


        //Enabling movement of Undecorated Frame
        FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);
    }
    public static JFrame getBaseFrame() {

        return frame;

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        try {
            MainScreen Mainscreen = new MainScreen();
            frame = Mainscreen.getBaseFrame();

        } catch (IOException e) {
            e.printStackTrace();
        }
        new LoginScreen(frame);
    }
}

