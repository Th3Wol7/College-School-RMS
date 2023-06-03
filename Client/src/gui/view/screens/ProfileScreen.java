package gui.view.screens;

import gui.utils.FrameUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileScreen extends JPanel implements ActionListener {
    private static Icon profileIcon;
    private static JLabel Logo;
    private JLabel titleLabel, IDLabel, firstNameLabel, lastNameLabel;
    private JLabel phoneLabel, emailLabel, DOBLabel, programmeLabel, addressLabel, enrolledLabel;
    private JTextField IDField, firstNameField, lastNameField, phoneField;
    private JTextField emailField, DOBField, schoolField, employerField, stateField;
    private JTextField lineSeparation, streetNumField, streetNameField, countryField;
    private JRadioButton yesBtn, noBtn;
    private JButton editBtn, saveBtn, cancelBtn;

    private ButtonGroup buttonGroup;

    public ProfileScreen() {
        initializeComponents();
        addComponentsToPanel();
        setWindowProperties();
        registerListeners();
        //setupProfile();
    }

    /*
    public ProfileScreen(Person user) {
        this.user = user;
        initializeComponents();
        addComponentsToPanel();
        setWindowProperties();
        registerListeners();
        setupProfile();
    }*/

    public void initializeComponents() {
        // profileIcon = new ImageIcon(new
        // ImageIcon(ShowProfile.class.getResource("image file path here")).getImage()
        // .getScaledInstance(100, 60, Image.SCALE_DEFAULT));
        // Logo = new JLabel(profileIcon);
        FrameUtility.addExitButton();
        FrameUtility.exitButton.setBounds(745, 0, 45, 45);
        FrameUtility.exitButton.setForeground(Color.BLACK);
        this.add(FrameUtility.exitButton);
        Font fieldFont = new Font("Oswald", Font.BOLD, 15);
        Font labelFont = new Font("Oswald", Font.BOLD, 16);

        titleLabel = new JLabel("My Profile", SwingConstants.CENTER);
        titleLabel.setBounds(280, 50, 200, 50);
        titleLabel.setFont(new Font("Oswald", Font.BOLD, 34));

        IDLabel = new JLabel("ID Number", SwingConstants.LEFT);
        IDLabel.setBounds(40, 150, 200, 50);
        IDLabel.setFont(labelFont);

        firstNameLabel = new JLabel("Firstname", SwingConstants.LEFT);
        firstNameLabel.setBounds(40, 235, 200, 50);
        firstNameLabel.setFont(labelFont);

        lastNameLabel = new JLabel("Lastname", SwingConstants.LEFT);
        lastNameLabel.setBounds(430, 235, 200, 50);
        lastNameLabel.setFont(labelFont);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(430, 150, 200, 50);
        emailLabel.setFont(labelFont);

        DOBLabel = new JLabel("D.O.B(DD/MM/YYYY)");
        DOBLabel.setBounds(40, 320, 200, 50); //430, 320, 200, 50
        DOBLabel.setFont(labelFont);

        phoneLabel = new JLabel("Telephone");
        phoneLabel.setBounds(430, 320, 200, 50); //430, 405, 200, 50
        phoneLabel.setFont(labelFont);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(40, 405, 200, 50);
        addressLabel.setFont(labelFont);

        enrolledLabel = new JLabel("Date Enrolled(DD/MM/YYYY)");
        enrolledLabel.setBounds(430, 405, 250, 50);
        enrolledLabel.setFont(labelFont);

        programmeLabel = new JLabel("Programme", SwingConstants.LEFT);
        programmeLabel.setBounds(430, 490, 200, 50); //40, 320, 200, 50 --
        programmeLabel.setFont(labelFont);

        lineSeparation = new JTextField(20);
        lineSeparation.setBounds(0, 100, 800, 25);// 125, 350, 250, uih
        lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
        lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        lineSeparation.setBackground(null);
        lineSeparation.setCaretColor(Color.gray);

        IDField = new JTextField(20);
        IDField.setBounds(40, 190, 250, 25);// 125, 350, 250, uih
        IDField.setHorizontalAlignment(SwingConstants.CENTER);
        IDField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        IDField.setBackground(getBackground());
        IDField.setForeground(Color.black);
        IDField.setFont(fieldFont);

        firstNameField = new JTextField(30);
        firstNameField.setBounds(40, 275, 250, 25);// 125, 350, 250, uih
        firstNameField.setHorizontalAlignment(SwingConstants.CENTER);
        firstNameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        firstNameField.setBackground(null);
        firstNameField.setForeground(Color.black);
        firstNameField.setFont(fieldFont);

        lastNameField = new JTextField(30);
        lastNameField.setBounds(430, 275, 250, 25);// 125, 350, 250, uih
        lastNameField.setHorizontalAlignment(SwingConstants.CENTER);
        lastNameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        lastNameField.setBackground(null);
        lastNameField.setForeground(Color.black);
        lastNameField.setFont(fieldFont);

        emailField = new JTextField(30);
        emailField.setBounds(430, 190, 250, 25);// 125, 350, 250, uih
        emailField.setHorizontalAlignment(SwingConstants.CENTER);
        emailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        emailField.setBackground(null);
        emailField.setForeground(Color.black);
        emailField.setFont(fieldFont);

        DOBField = new JTextField(30);
        DOBField.setBounds(40, 360, 250, 25);
        DOBField.setHorizontalAlignment(SwingConstants.CENTER);
        DOBField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        DOBField.setBackground(null);
        DOBField.setForeground(Color.black);
        DOBField.setFont(fieldFont);

        phoneField = new JTextField(20);
        phoneField.setBounds(430, 360, 250, 25);// 430, 445, 250, 25
        phoneField.setHorizontalAlignment(SwingConstants.CENTER);
        phoneField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        phoneField.setBackground(null);
        phoneField.setForeground(Color.black);
        phoneField.setFont(fieldFont);

        schoolField = new JTextField(30);
        schoolField.setBounds(430, 445, 250, 25);
        schoolField.setHorizontalAlignment(SwingConstants.CENTER);
        schoolField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        schoolField.setBackground(null);
        schoolField.setForeground(Color.black);
        schoolField.setFont(fieldFont);

        streetNumField = new JTextField("street number",7);
        streetNumField.setBounds(40, 445, 250, 25);
        streetNumField.setHorizontalAlignment(SwingConstants.CENTER);
        streetNumField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        streetNumField.setBackground(null);
        streetNumField.setForeground(Color.gray);
        streetNumField.setFont(fieldFont);

        streetNameField = new JTextField("street name", 30);
        streetNameField.setBounds(40, 490, 250, 25);// 125, 350, 250, uih
        streetNameField.setHorizontalAlignment(SwingConstants.CENTER);
        streetNameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        streetNameField.setBackground(null);
        streetNameField.setForeground(Color.gray);
        streetNameField.setFont(fieldFont);

        stateField = new JTextField("state", 30);
        stateField.setBounds(40, 535, 250, 25);
        stateField.setHorizontalAlignment(SwingConstants.CENTER);
        stateField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        stateField.setBackground(null);
        stateField.setForeground(Color.gray);
        stateField.setFont(fieldFont);

        yesBtn = new JRadioButton("Yes");
        yesBtn.setBounds(140, 510, 65, 20);
        yesBtn.setFont(labelFont);
        yesBtn.setOpaque(false);
        yesBtn.setFocusPainted(false);

        noBtn = new JRadioButton("No");
        noBtn.setBounds(230, 510, 50, 20);
        noBtn.setFont(labelFont);
        noBtn.setOpaque(false);
        noBtn.setFocusPainted(false);

        editBtn = new JButton("Edit");
        editBtn.setBounds(510, 530, 120, 30);
        editBtn.setFont(labelFont);
        editBtn.setOpaque(true);
        editBtn.setBorderPainted(false);
        editBtn.setBackground(new Color(224, 224, 224));
        editBtn.setFocusPainted(false);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(450, 530, 120, 30);
        saveBtn.setFont(labelFont);
        saveBtn.setOpaque(true);
        saveBtn.setBorderPainted(false);
        saveBtn.setBackground(new Color(224, 224, 224));
        saveBtn.setFocusPainted(false);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(590, 530, 120, 30);
        cancelBtn.setFont(labelFont);
        cancelBtn.setOpaque(true);
        cancelBtn.setBorderPainted(false);
        cancelBtn.setBackground(new Color(224, 224, 224));
        cancelBtn.setFocusPainted(false);

        IDField.setEnabled(false);
        firstNameField.setEnabled(false);
        lastNameField.setEnabled(false);
        phoneField.setEnabled(false);
        emailField.setEnabled(false);
        DOBField.setEnabled(false);
        schoolField.setEnabled(false);
        streetNumField.setEnabled(false);
        streetNameField.setEnabled(false);
        stateField.setEnabled(false);
        yesBtn.setEnabled(false);
        noBtn.setEnabled(false);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(yesBtn);
        buttonGroup.add(noBtn);

    }

    public void addComponentsToPanel() {
        // profilePanel.add(Logo);
        this.add(titleLabel);
        this.add(lineSeparation);
        this.add(IDLabel);
        this.add(IDField);
        this.add(emailLabel);
        this.add(emailField);
        this.add(firstNameLabel);
        this.add(firstNameField);
        this.add(lastNameLabel);
        this.add(lastNameField);
        this.add(programmeLabel);
        this.add(schoolField);
        this.add(DOBLabel);
        this.add(DOBField);
        this.add(addressLabel);
        this.add(streetNumField);
        this.add(streetNameField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(enrolledLabel);
        this.add(streetNumField);
        this.add(streetNameField);
        this.add(stateField);
        this.add(editBtn);
    }

    public void setWindowProperties() {
        this.setPreferredSize(new Dimension(710, 1500));
        this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
        this.setLayout(null);
        //this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //this.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public void registerListeners() {
        yesBtn.addActionListener(this);
        noBtn.addActionListener(this);
        editBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }

    // This method adds the users data to the respective fields on the screen
        /*public void setupProfile() {
            if (user != null) {
                IDField.setText(user.getUsername());
                firstNameField.setText(user.getFirstName());
                lastNameField.setText(user.getLastName());
                phoneField.setText(user.getPhone());
                emailField.setText(user.getEmail());
                DOBField.setText(user.getCommunity());
                schoolField.setText(user.getSchool());
                employerField.setText(user.getEmployer());
                if (user.getPrivacy() == 1) {
                    yesBtn.setSelected(true);
                    noBtn.setSelected(false);
                } else {
                    noBtn.setSelected(true);
                    yesBtn.setSelected(false);
                }
            }
        }

        // This method updates the new info entered by the user;
        // This method only updates the user in the file not in the network
        public void updateUser() {// NTS: Test this method
            String username = IDField.getText().trim().replaceAll("\\s", "");
            String firstName = firstNameField.getText().trim().replaceAll("\\s", "");
            String lastName = lastNameField.getText().trim().replaceAll("\\s", "");
            String phone = phoneField.getText().trim().replaceAll("\\s", "");
            String email = emailField.getText().trim().replaceAll("\\s", "");
            String community = DOBField.getText().trim().replaceAll("\\s", "");
            String school = schoolField.getText().trim().replaceAll("\\s", "");
            String employer = employerField.getText().trim().replaceAll("\\s", "");
            int privacy = 0;
            if (yesBtn.isSelected() == true) {
                privacy = 1;
            }
            Scanner inFileStream = null;
            FileWriter outFileStream = null;

            File dataTempFile = new File("./database/tempPeopleDatabase.txt");
            File databaseFile = new File("./database/peopleCopy.txt");

            try {
                inFileStream = new Scanner(databaseFile);
                outFileStream = new FileWriter(dataTempFile);
                while (inFileStream.hasNext()) {
                    String username2 = inFileStream.next();
                    String firstName2 = inFileStream.next();
                    String lastName2 = inFileStream.next();
                    String phone2 = inFileStream.next();
                    String email2 = inFileStream.next();
                    String community2 = inFileStream.next();
                    String school2 = inFileStream.next();
                    String employer2 = inFileStream.next();
                    int privacy2 = inFileStream.nextInt();
                    String record = username2 + "\t" + firstName2 + "\t" + lastName2 + "\t" + phone2 + "\t" + email2 + "\t"
                            + community2 + "\t" + school2 + "\t" + employer2 + "\t" + privacy2 + "\n";

                    if (username2.equals(getUser().getUsername())) {
                        Person person1 = new Person(username, firstName, lastName, phone, email, community, school,
                                employer, privacy, getUser().getActivity());
                        record = username + "\t" + firstName + "\t" + lastName + "\t" + phone + "\t" + email + "\t"
                                + community + "\t" + school + "\t" + employer + "\t" + privacy + "\n";
                        setUser(person1);
                    }
                    outFileStream.write(record);
                }
                inFileStream.close();
                outFileStream.close();
            } catch (FileNotFoundException fnfe) {
                System.err.println("File could not be found: " + fnfe.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (inFileStream != null) {
                    inFileStream.close();
                }
            }

        }
*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editBtn) {
            editBtn.setVisible(false);
            this.remove(editBtn);
            this.add(saveBtn);
            this.add(cancelBtn);
            cancelBtn.setVisible(true);
            IDField.setEnabled(true);
            firstNameField.setEnabled(true);
            lastNameField.setEnabled(true);
            phoneField.setEnabled(true);
            emailField.setEnabled(true);
            DOBField.setEnabled(true);
            schoolField.setEnabled(true);
            employerField.setEnabled(true);
            yesBtn.setEnabled(true);
            noBtn.setEnabled(true);
        }
  /*          if (e.getSource() == saveBtn) {
                // remove spaces from address, school, employer and name entered
                // update file database, update tree
                if (!IDField.getText().equals("") && !firstNameField.getText().equals("")
                        && !lastNameField.getText().equals("") && !phoneField.getText().equals("")
                        && !emailField.getText().equals("") && !DOBField.getText().equals("")
                        && !schoolField.getText().equals("") && !employerField.getText().equals("")) {
                    updateUser();
                    this.add(editBtn);
                    cancelBtn.setVisible(false);
                    this.remove(cancelBtn);
                    this.remove(saveBtn);
                    editBtn.setVisible(true);
                    IDField.setEnabled(false);
                    firstNameField.setEnabled(false);
                    lastNameField.setEnabled(false);
                    phoneField.setEnabled(false);
                    emailField.setEnabled(false);
                    DOBField.setEnabled(false);
                    schoolField.setEnabled(false);
                    employerField.setEnabled(false);
                    yesBtn.setEnabled(false);
                    noBtn.setEnabled(false);
                } else {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "One or more field empty", "Missing info",
                            JOptionPane.INFORMATION_MESSAGE);

                    try {
                        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            if (e.getSource() == cancelBtn) {
                this.add(editBtn);
                cancelBtn.setVisible(false);
                // saveBtn.setVisible(false);
                this.remove(cancelBtn);
                this.remove(saveBtn);
                editBtn.setVisible(true);
                IDField.setEnabled(false);
                firstNameField.setEnabled(false);
                lastNameField.setEnabled(false);
                phoneField.setEnabled(false);
                emailField.setEnabled(false);
                DOBField.setEnabled(false);
                schoolField.setEnabled(false);
                employerField.setEnabled(false);
                yesBtn.setEnabled(false);
                noBtn.setEnabled(false);

                IDField.setText(user.getUsername());
                firstNameField.setText(user.getFirstName());
                lastNameField.setText(user.getLastName());
                phoneField.setText(user.getPhone());
                emailField.setText(user.getEmail());
                DOBField.setText(user.getCommunity());
                schoolField.setText(user.getSchool());
                employerField.setText(user.getEmployer());
                if (user.getPrivacy() == 1) {
                    yesBtn.setSelected(true);
                    noBtn.setSelected(false);
                } else {
                    noBtn.setSelected(true);
                    yesBtn.setSelected(false);
                }

            }
            if (e.getSource() == yesBtn) {
                noBtn.setSelected(false);
            }
            if (e.getSource() == noBtn) {
                yesBtn.setSelected(false);
            }
        }

    }*/
    }
}
