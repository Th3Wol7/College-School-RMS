package gui.view.screens;

import gui.utils.FrameUtility;
import model.User;

/*
image credit - paper clips PNG Designed By 渣渣 from
https://pngtree.com/freepng/book-learning-stationery-combination-map_5506167.html?sol=downref&id=bef
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

import static java.awt.Font.*;

public class LoginScreen implements ActionListener {
    final int panWidth = 1000;
    final int panHeight = 600;
    final int uih = 25;
    final int newUserSetX = 400;
    final int newUserSetY = 520;
    final int newUserOffsetX = newUserSetX - 25;
    final int newUserOffsetY = newUserSetY;
    private static Color userPicColor;
    private static Color userLogColor;
    private static Color newUserPicColor;
    private static Color newUserLogColor;
    private static Font Oswald;
    private static JPanel adminPanel;
    private static JPanel loginPanel, userPanel, imagePanel;
    private static JLabel welcomeLabel1, welcomeLabel2;
    private static JLabel instituteLabel1, instituteLabel2;
    private static JLabel picLabel;
    private static Icon mainIcon;
    private static JTextField userName;
    private static JTextArea userSwap;
    private static JPasswordField passwordField;
    private static JToggleButton adminButton;
    private static JButton loginButton;
    private final JFrame frame;
    private JToggleButton swapButton;

    public LoginScreen(JFrame frame) {
        this.frame = frame;
        initializeComponents();
        addListeners();
    }

    public void initializeComponents() {
        newUserPicColor = new Color(207, 209, 219);
        newUserLogColor = new Color(190, 71, 11);

        userLogColor = new Color(216, 227, 241);
        userPicColor = new Color(65, 172, 158);

        Oswald = new Font("Oswald", BOLD, 15);
        Font oswald_Small = new Font("Oswald", BOLD, 10);

        mainIcon = new ImageIcon(new ImageIcon(Objects.requireNonNull(MainScreen.class.getResource("/gui/res/loginImage.png"))).getImage()
                .getScaledInstance(300, 350, Image.SCALE_DEFAULT));

        // Assigns default image to variable
        picLabel = new JLabel(mainIcon);
        picLabel.setBounds(70, 0, 300, 400);

        instituteLabel1 =  new JLabel("Home & Away");
        instituteLabel1.setBounds(130, 390, 500, uih+20);
        instituteLabel1.setForeground(Color.WHITE);
        instituteLabel1.setFont(new Font("Oswald", BOLD, 34));

        instituteLabel2 = new JLabel("University");
        instituteLabel2.setBounds(160, 450, 250, 50);
        instituteLabel2.setForeground(Color.WHITE);
        instituteLabel2.setFont(new Font("Oswald", BOLD, 34));

        welcomeLabel1 = new JLabel("Record", SwingConstants.CENTER);
        welcomeLabel1.setBounds(150, 120, 200, 50);
        welcomeLabel1.setForeground(Color.BLACK);
        welcomeLabel1.setFont(new Font("Oswald", BOLD, 34));

        welcomeLabel2 = new JLabel("Management", SwingConstants.CENTER);
        welcomeLabel2.setBounds(130, 170, 250, 50);
        welcomeLabel2.setForeground(Color.BLACK);
        welcomeLabel2.setFont(new Font("Oswald", BOLD, 34));

        userName = new JTextField(25);
        userName.setText("username");
        userName.setBounds(125, 270, 250, uih);// 125, 350, 250, uih
        userName.setHorizontalAlignment(SwingConstants.CENTER);
        userName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        userName.setBackground(null);
        userName.setForeground(Color.BLACK);
        userName.setFont(Oswald);
        userName.setCaretColor(Color.BLACK);

        passwordField = new JPasswordField("password");
        passwordField.setBounds(125, 350, 250, uih);
        passwordField.setVisible(true);// false/////
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        passwordField.setBackground(null);
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(Oswald);
        passwordField.setCaretColor(Color.BLACK);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 420, 100, uih);
        loginButton.setOpaque(true);
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(Oswald);
        loginButton.setBorder(new FrameUtility.RoundedBorder(25));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        userSwap = new JTextArea("Are you an Administrator?");
        userSwap.setEditable(false);
        userSwap.setBounds(newUserSetX, newUserSetY, 75, 35);
        userSwap.setLineWrap(true);
        userSwap.setWrapStyleWord(true);
        userSwap.setOpaque(false);
        userSwap.setFont(oswald_Small);
        userSwap.setForeground(Color.BLACK);
        userSwap.setBackground(null);
        userSwap.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        userSwap.setVisible(true);

        swapButton = new JToggleButton("<HTML><U>Click Here</U></HTML>");
        swapButton.setBounds(newUserOffsetX, newUserOffsetY, 100, uih+50);
        swapButton.setForeground(Color.BLACK);
        swapButton.setFont(oswald_Small);
        swapButton.setBorderPainted(false);
        swapButton.setContentAreaFilled(false);
        swapButton.setFocusPainted(false);
        swapButton.setOpaque(false);
        swapButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        loginPanel = new JPanel();
        loginPanel.setBounds(0, 0, panWidth, panHeight);
        loginPanel.setLayout(new GridLayout(1, 2));

        userPanel = new JPanel();
        userPanel.setLayout(null);
        userPanel.setBackground(userLogColor);

        imagePanel = new JPanel();
        imagePanel.setLayout(null);
        imagePanel.setBackground(userPicColor);

        imagePanel.add(picLabel);
        imagePanel.add(instituteLabel1);
        imagePanel.add(instituteLabel2);

        FrameUtility.addExitButton();
        FrameUtility.exitButton.setBounds(455, 0, 50, 35);
        userPanel.add(FrameUtility.exitButton);
        FrameUtility.exitButton.setFont(new Font("oswald", PLAIN, 16));

        userPanel.add(welcomeLabel1);
        userPanel.add(welcomeLabel2);
        userPanel.add(loginButton);
        userPanel.add(userName);
        userPanel.add(passwordField);
        userPanel.add(userSwap);
        userPanel.add(swapButton);

        loginPanel.add(imagePanel);
        loginPanel.add(userPanel);

        frame.add(loginPanel);
    }

    public void addListeners() {
        loginButton.addActionListener(this);
        userName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userName.getText().equals("username")) {
                    userName.setText(null);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userName.getText().equals("")) {
                    userName.setText("username");

                }

            }

        });
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                char[] passwordChar = passwordField.getPassword();
                String password = String.valueOf(passwordChar);
                if (password.equalsIgnoreCase("Password")) {
                    passwordField.setText(null);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                char[] passwordChar = passwordField.getPassword();
                String password = String.valueOf(passwordChar);
                if (password.equals("")) {
                    passwordField.setText("Password");
                }

            }

        });

        swapButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                registerPressed(itemEvent);
            }
        });

    }

    protected void registerPressed(ItemEvent itemEvent) {
        int state = itemEvent.getStateChange();
        if (state == ItemEvent.SELECTED) {
            instituteLabel1.setForeground(Color.BLACK);
            instituteLabel2.setForeground(Color.BLACK);
            imagePanel.setBackground(newUserLogColor);
            userPanel.setBackground(newUserPicColor);
            userSwap.setText("Not an Administrator?");
        } else {
            instituteLabel1.setForeground(Color.WHITE);
            instituteLabel2.setForeground(Color.WHITE);
            imagePanel.setBackground(userPicColor);
            userPanel.setBackground(userLogColor);
            userSwap.setText("Are you an Administrator?");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            loginPanel.setVisible(false);
            loginPanel.removeAll();
            frame.remove(loginPanel);
            new BaseScreen(frame);
        }
    }

}
