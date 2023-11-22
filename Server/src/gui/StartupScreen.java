package gui;

import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.*;
import java.util.Objects;

public class StartupScreen extends JWindow {
    private JProgressBar progressBar;
    private JPanel panel;
    private JLabel startupIcon;

    public StartupScreen() {
        initializeComponents();
        addComponentsToPanels();
        addPanelsToWindow();
        setWindowProperties();
    }

    private void initializeComponents() {
        // progress bar properties
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);

        // Load the image
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/res/startupImage.png")));
        //image taken from : https://www.filehold.com/sites/default/files/2022-05/home-page-top-image-500.png

        // Get the image from the icon
        Image originalImage = originalIcon.getImage();

        // Resize the image
        Image resizedImage = originalImage.getScaledInstance(550, 386, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the resized image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Create the JLabel with the resized ImageIcon
        startupIcon = new JLabel(resizedIcon);

        // Panel properties
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(550, 400);
        panel.setBackground(new Color(255, 255, 255));
    }

    private void addComponentsToPanels() {
        panel.add(startupIcon);
        panel.add(progressBar);
    }

    private void addPanelsToWindow() {
        add(panel);
    }

    private void setWindowProperties() {
        setSize(550, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}