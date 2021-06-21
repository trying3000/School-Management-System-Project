package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyLoginGUI implements ActionListener {


     JLabel nameLabel;
     JTextField userText;
     JLabel passwordLabel;
     JPasswordField passwordText;
     JButton button;
     JButton cancelButton;
     JLabel menuLabel;
     JPanel panel = new JPanel();
     JFrame frame = new JFrame();

    FacultyLoginGUI(){ //constructor

        // frame size and titles

        frame.setSize(400, 220);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("School Management System");
        frame.add(panel);
        panel.setLayout(null);

        //name label setup

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(5, 40, 80, 25);
        panel.add(nameLabel);

        //password label setup

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(5, 70, 80, 25);
        panel.add(passwordLabel);

        //text box for name entry

        userText = new JTextField(20);
        userText.setBounds(100, 40, 165, 25);
        panel.add(userText);

        //password text box for password entry

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 70, 165, 25);
        panel.add(passwordText);

        //login button setup

        button = new JButton("Login");
        button.setBounds(10, 120, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        //cancel button setup

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(120, 120, 80, 25);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);


        menuLabel = new JLabel("Faculty Login...");
        menuLabel.setBounds(5,2,200,25);
        panel.add(menuLabel);

        // set the frame to be visible so it shows up on the screen

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // if user presses cancel button that is button2, go back

        if (e.getSource() == cancelButton) {
            frame.setVisible(false);
            new Main.GUI();
        }

        //else ask for name and password via built in javax swing methods getText

        else {
            frame.setVisible(false);
            String name = userText.getText();
            String pass = passwordText.getText();

            System.out.println("Logged In As: " + name);
            new FacultyMain();
        }
    }
}

