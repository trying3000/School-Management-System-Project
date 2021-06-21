package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


                    /*School Management System
                                By
                                    Waleed Afzaal Yousaf
                     */

public class Main {

    public static void main(String[] args) {

        /* call GUI method */

	new GUI();

    }

    public static class GUI implements ActionListener {

        JButton adminButton;
        JButton facultyButton;
        JLabel choiceLable;
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        GUI(){

            //set frame and panel

            frame.setSize(400, 150);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("School Management System");
            frame.add(panel);
            panel.setLayout(null);

            choiceLable = new JLabel("LOGIN AS : ");
            choiceLable.setBounds(5, 20, 80, 25);
            panel.add(choiceLable);

            //make adminButton

            adminButton = new JButton("ADMIN");
            adminButton.setBounds(100, 20, 100, 25);
            adminButton.addActionListener(this);

            panel.add(adminButton);

            //make facultyButton

            facultyButton = new JButton("FACULTY");
            facultyButton.setBounds(250, 20, 100, 25);
            facultyButton.addActionListener(this);
            panel.add(facultyButton);

            frame.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //if admin button is pressed

            if (e.getSource()== adminButton){
                frame.dispose();
                new AdminLoginGUI();
                System.out.println("Admin menu appeared");
            }

            //if faculty button is pressed

            else if (e.getSource()== facultyButton){
                frame.dispose();
                new FacultyLoginGUI();
                System.out.println("Faculty menu appeared");
            }
        }
    }
}
