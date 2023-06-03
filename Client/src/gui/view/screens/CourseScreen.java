package gui.view.screens;

import gui.utils.FrameUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseScreen extends JPanel implements ActionListener {
    private JPanel holderPanel;
    private JButton button1, button2;
    private JScrollPane scrollPane;
    public CourseScreen(){
        initializeComponents();
        setWindowProperties();
    }

    private void initializeComponents(){
        FrameUtility.addExitButton();
        FrameUtility.exitButton.setBounds(745, 0, 50, 50);
        FrameUtility.exitButton.setForeground(Color.BLACK);
        this.add(FrameUtility.exitButton);

    }

    public void setWindowProperties() {
        this.setPreferredSize(new Dimension(710, 1500));
        this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
