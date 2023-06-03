package gui.view.screens;

/*This class represents the Initial home Screen of the application
 * @author Tyrien Gilpin
 * Version 1
 */

import gui.utils.FrameUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class BaseScreen implements ActionListener {//NTS: Primary panel is what you add stuff to
    private static Font Oswald;
    private static JPanel sidePanel, userPanel;
    JScrollPane primaryPanel;
    private static JLabel Logo;
    private static Icon defaultLogoIcon;
    private static JButton profileButton, courseButton;
    private static JButton programmeButton, studentButton;
    private static JButton homeButton, logOutButton;
    final int panWidth = 1000;
    final int panHeight = 600;
    final int buttonHeight = 220;
    private final JFrame frame;

    public BaseScreen(JFrame frame) {
        this.frame = frame;
        initializeComponents();
    }

    public void initializeComponents() {
        frame.setLayout(new BorderLayout());
        Oswald = new Font("Oswald", Font.BOLD, 15);
        Color buttonColor = new Color(0, 0, 0);

        try {
            //Setting look and feel of application to that similar to the LAF of the user's system
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Assigns default image to variable
            defaultLogoIcon = new ImageIcon(new ImageIcon(Objects.requireNonNull(MainScreen.class.getResource("/gui/res/loginImage.png"))).getImage()
                    .getScaledInstance(150, 170, Image.SCALE_DEFAULT));

            Logo = new JLabel(defaultLogoIcon);
            Logo.setBounds(20, 5, 160, 180);
        } catch (Exception e) {
            System.out.println("Home Screen Image could not be found");
        }

        userPanel = new JPanel();//main panel that covers frame
        sidePanel = new JPanel(); //side panels that holds main button
        primaryPanel = new JScrollPane();//panel that changes it screen

        // Setting panel background colour
        sidePanel.setBackground(new Color(65, 172, 158));
        sidePanel.setLayout(null);

        // sets layout to be null, to allow for free placement of JComponenets
        primaryPanel.setBackground(new Color(242, 242, 242));
        primaryPanel.setPreferredSize(new Dimension(400, 400));
        primaryPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        primaryPanel.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        primaryPanel.getVerticalScrollBar().setUnitIncrement(16);

        // Set the system scrollpane border
        primaryPanel.setBorder(BorderFactory.createEmptyBorder());

        userPanel.setBounds(0, 0, panWidth, panHeight);
        userPanel.setLocation(0, 0);
        userPanel.setSize(panWidth, panHeight);
        userPanel.setLayout(new BorderLayout());
        userPanel.setBackground(Color.black);

        FrameUtility.addExitButton();
        FrameUtility.exitButton.setBounds(755, 0, 45, 45);
        FrameUtility.exitButton.setForeground(buttonColor);
        primaryPanel.add(FrameUtility.exitButton);

        //adds created panels to main Panel
        sidePanel.setPreferredSize(new Dimension(200, 600));
        userPanel.add(sidePanel, BorderLayout.WEST);

        primaryPanel.setPreferredSize(new Dimension(800, 600));
        userPanel.add(primaryPanel, BorderLayout.CENTER);

        configureButtons();
        addComponentsToPanels();
        registeringListeners();

        frame.add(userPanel);
    }


    // Setting up buttons and their properties
    public void configureButtons() {
        homeButton = new JButton("HOME");
        homeButton.setBounds(0, buttonHeight - 60, 200, 50);
        homeButton.setOpaque(false);
        homeButton.setFocusPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setForeground(Color.white);
        homeButton.setFont(Oswald);
        homeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        profileButton = new JButton("PROFILE");
        profileButton.setBounds(0, buttonHeight + 10, 200, 50);//0, buttonHeight - 60, 200, 50);
        profileButton.setOpaque(false);
        profileButton.setFocusPainted(false);
        profileButton.setContentAreaFilled(false);
        profileButton.setForeground(Color.white);
        profileButton.setFont(Oswald);
        profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profileButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));

        courseButton = new JButton("COURSE");
        courseButton.setBounds(0, buttonHeight + 85, 200, 50);//0, buttonHeight + 10, 200, 50);
        courseButton.setOpaque(false);
        courseButton.setFocusPainted(false);
        courseButton.setContentAreaFilled(false);
        courseButton.setForeground(Color.white);
        courseButton.setFont(Oswald);
        courseButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        courseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        programmeButton = new JButton("PROGRAMME");
        programmeButton.setBounds(0, buttonHeight + 160, 200, 50);//0, buttonHeight + 85, 200, 50);
        programmeButton.setOpaque(false);
        programmeButton.setFocusPainted(false);
        programmeButton.setContentAreaFilled(false);
        programmeButton.setForeground(Color.white);
        programmeButton.setFont(Oswald);
        programmeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        programmeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        studentButton = new JButton("STUDENT");
        studentButton.setBounds(0, buttonHeight + 240, 200, 50);//0, buttonHeight + 160, 200, 50);
        studentButton.setOpaque(false);
        studentButton.setFocusPainted(false);
        studentButton.setContentAreaFilled(false);
        studentButton.setForeground(Color.white);
        studentButton.setFont(Oswald);
        studentButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        studentButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        logOutButton = new JButton("LOGOUT");
        logOutButton.setBounds(0, buttonHeight + 310, 200, 50);
        logOutButton.setOpaque(false);
        logOutButton.setFocusPainted(false);
        logOutButton.setContentAreaFilled(false);
        logOutButton.setForeground(Color.white);
        logOutButton.setFont(Oswald);
        logOutButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        logOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    private void addComponentsToPanels() {
        sidePanel.add(Logo);
        sidePanel.add(profileButton);
        sidePanel.add(courseButton);
        sidePanel.add(programmeButton);
        sidePanel.add(studentButton);
        sidePanel.add(homeButton);
        sidePanel.add(logOutButton);
    }

    public void registeringListeners() {
        homeButton.addActionListener(this);
        profileButton.addActionListener(this);
        courseButton.addActionListener(this);
        programmeButton.addActionListener(this);
        studentButton.addActionListener(this);
        logOutButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(homeButton)) {
            //primaryPanel.setViewportView(new HomeScreen(user));
            primaryPanel.repaint();
            primaryPanel.revalidate();
        }
        if (e.getSource().equals(profileButton)) {
            primaryPanel.setViewportView(new ProfileScreen());
            primaryPanel.repaint();
            primaryPanel.revalidate();
        }
        if (e.getSource().equals(courseButton)) {
            primaryPanel.setViewportView(new CourseScreen());
            primaryPanel.repaint();
            primaryPanel.revalidate();

        }
        if (e.getSource().equals(programmeButton)) {
  //        primaryPanel.setViewportView(new ProgrammeScreen(user));
            primaryPanel.repaint();
            primaryPanel.revalidate();

        }
        if (e.getSource().equals(studentButton)) {
            //primaryPanel.setViewportView(new ProgrammeScreen(user));
            primaryPanel.repaint();
            primaryPanel.revalidate();
        }
        if (e.getSource() == logOutButton) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            int option = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Log Out",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                frame.remove(userPanel);
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new LoginScreen(frame);
            }
        }
    }
}
