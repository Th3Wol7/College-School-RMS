package gui.view.screens;

import gui.utils.FrameUtility;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseScreen extends JPanel implements ActionListener {
    private JLabel titleLabel;
    private JTextField lineSeparation;
    private JEditorPane textPane, infoPane;
    public CourseScreen(){
        initializeComponents();
        addComponentsToPanel();
        setWindowProperties();
        registerListeners();
    }

    private void initializeComponents(){
        FrameUtility.addExitButton();
        FrameUtility.exitButton.setBounds(745, 0, 50, 50);
        FrameUtility.exitButton.setForeground(Color.BLACK);
        this.add(FrameUtility.exitButton);

        Font fieldFont = new Font("Oswald", Font.BOLD, 15);
        Font labelFont = new Font("Oswald", Font.BOLD, 16);

        titleLabel = new JLabel("Courses", SwingConstants.CENTER);
        titleLabel.setBounds(280, 50, 200, 50);
        titleLabel.setFont(new Font("Oswald", Font.BOLD, 34));

        lineSeparation = new JTextField(20);
        lineSeparation.setBounds(0, 100, 800, 25);// 125, 350, 250, uih
        lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
        lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        lineSeparation.setBackground(null);
        lineSeparation.setCaretColor(Color.gray);

        infoPane = new JEditorPane();
        infoPane.setText("This section provides information about the courses offered at this institution. " +
                "To access detailed information about a course, simply click on the tabs that contain a summary of each course.");
        infoPane.setPreferredSize(new Dimension(680, 300));
        infoPane.setBounds(60, 150, 680, 50);
        infoPane.setFont(new Font("Oswald", Font.PLAIN, 16));


        textPane = new JEditorPane();
        textPane.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
                "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit " +
                "anim id est laborum.");
        textPane.setPreferredSize(new Dimension(680, 300));
        textPane.setBounds(60, 230, 680, 100);
        textPane.setFont(new Font("Oswald", Font.BOLD, 20));

        // Create a border for the text pane
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        Border roundedBorder = BorderFactory.createCompoundBorder(
                border,
                BorderFactory.createEmptyBorder(30, 10, 10, 10)
        );
        textPane.setBorder(roundedBorder);
        infoPane.setBorder(roundedBorder);

    }

    private void addComponentsToPanel(){
        this.add(titleLabel);
        this.add(lineSeparation);
        this.add(infoPane);
        this.add(textPane);
    }

    private void registerListeners(){

    }


    public void setWindowProperties() {
        this.setPreferredSize(new Dimension(710, 1500));
        this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
        this.setLayout(null);
        // this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
