package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminLoginGUI implements ActionListener {


        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        JLabel nameLabel;
        JTextField userText;
        JLabel passwordLabel;
        JPasswordField passwordText;
        JButton button;
        JButton cancelButton;
        JLabel menuLabel;


        AdminLoginGUI() {

            //set frame size and titles

            frame.setSize(400, 220);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("School Management System");
            frame.add(panel);
            panel.setLayout(null);

            //name label
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

            passwordText = new JTextField();
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

            menuLabel = new JLabel("Admin Login...");
            menuLabel.setBounds(5, 2, 200, 25);
            panel.add(menuLabel);

            // set the frame to be visible so it shows up on the screen

            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //if cancel button is pressed go back

            if (e.getSource() == cancelButton) {
                frame.dispose();
                new Main.GUI();
            }

            //otherwise get username and password that is hard coded

            else {

                //use built in methods getText to get name and password from user

                String name = userText.getText();
                String pass = passwordText.getText();

                if (name.equals("Azfar Shakeel") || name.equals("azfar shakeel") && pass.equals("admin123")) {
                    frame.setVisible(false);
                    System.out.println("Logged In As: " + name);
                    new AdminMain();
                }
                else {
                    /* import standard dialogue box */

                    JOptionPane.showMessageDialog(frame, "Invalid username or password");
                }
            }
        }
}

