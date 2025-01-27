package com.quizapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame{

    JButton start, back;//Without global declaration, these components wouldn't be accessible in the listener methods if we declared these 2 locally These would only be accessible within the constructor ActionListeners wouldn't be able to access them

    Login() {

        getContentPane().setBackground(Color.WHITE); //setting the BG color of Frame
        setLayout(null); // null so that we can create our own layout

        JLabel title = new JLabel("Welcome to Quiz Application");
        title.setBounds(250, 60, 700, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.BLACK);
        add(title);

        JLabel message = new JLabel("Login Success!");
        message.setBounds(330, 90, 700, 30);
        message.setFont(new Font("Arial", Font.BOLD, 15));
        message.setForeground(Color.BLACK);
        add(message);

        JLabel subhead = new JLabel("Rules to Know: ");
        subhead.setBounds(20, 120, 700, 30);
        subhead.setFont(new Font("Arial", Font.BOLD, 15));
        subhead.setForeground(Color.BLACK);
        add(subhead);

        JLabel rules = new JLabel();
        rules.setBounds(40, 130, 700, 300);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rules.setText( //setting text we can use this method in Jlabel class
                "<html>"+
                        "1. Total Quiz Time is 5 minutes." + "<br><br>" +
                        "2. Each Question carries 1 mark, No negative marking." + "<br><br>" +
                        "3. Each Question has individual timer." + "<br><br>" +
                        "4. Malpractice is not encouraged." + "<br><br>" +
                        "5. No doubts are answered during Quiz." + "<br><br>" +
                        "6. Results will be displayed at the end." + "<br><br>" +
                        "                    Good Luck                        " + "<br><br>" +
                        "<html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(20,400,80,25);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); //closing login frame
                new Home();//creating home class object. u can create in Home h = new Home but here we are not storing it in any variable.
            }
        });
        add(back);

        start = new JButton("Start");
        start.setBounds(200,400,80,25);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); //closing the frame of Login
                new Quiz(); //creating Quiz class object. u can create in Quiz h = new Quiz but here we are not storing it in any variable.
            }
        });
        add(start);

        setSize(800, 650);
        setLocation(500, 250);
        setVisible(true);
    }



    public static void main(String[] args) {
        new Login();//creating Login class object. u can create in Login h = new Login but here we are not storing it in any variable.
    }
}