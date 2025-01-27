package com.quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{

    JTextField tfname,tfempid; //Without global declaration, these components wouldn't be accessible in the listener methods
    JButton login, close; // if we declared these 4 locally These would only be accessible within the constructor ActionListeners wouldn't be able to access them

    Home() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Quiz App");
        heading.setBounds(200, 60, 100, 40); // setting the location
        heading.setFont(new Font("Arial", Font.BOLD, 20)); //font
        heading.setForeground(Color.DARK_GRAY); //font colour
        add(heading); // use this method to display this heading in Jframe

        JLabel name = new JLabel("Enter your name");
        name.setBounds(175, 140, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(Color.BLACK);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(175, 160, 180, 25);
        tfname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tfname.addActionListener(new ActionListener() // Adds the specified action listener to receive action events from this textfield. comes from action listener package it contains a functional interface with action performed unimplemented method.
        {
            public void actionPerformed(ActionEvent e) // implementing that method.
            {
                tfempid.requestFocusInWindow(); // this will bring focus to the block when we click enter.
            }
        });
        add(tfname);

        JLabel empid = new JLabel("Enter your EMP_ID");
        empid.setBounds(175, 200, 300, 20);
        empid.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        empid.setForeground(Color.BLACK);
        add(empid);

        tfempid = new JTextField();
        tfempid.setBounds(175, 220, 180, 25);
        tfempid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tfempid.addActionListener(new ActionListener() //here we are creating anonymous  new ActionListner creates a new instance of a class that implements ActionListener
//        class Home implements ActionListener {
//            public void actionPerformed(ActionEvent e) {
//                login.requestFocusInWindow();
//            }
//        }
//        tfempid.addActionListener(new MyListener());  both are same
        {
            public void actionPerformed(ActionEvent e)
            {
                login.requestFocusInWindow();
            }
        });
        add(tfempid);

        login = new JButton("Login");
        login.setBounds(175,260,80,25);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLogin(); // here it will call this method.
            }
        });
        add(login);

        close = new JButton("Close");
        close.setBounds(275,260,80,25);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); //this will close the frame.
            }
        });
        add(close);

        setSize(500, 500); //setting the size of Frame
        setLocation(350, 250); // Location where it should open
        setVisible(true);
    }

    public void openLogin(){
        setVisible(false); // closing the frame
        new Login();//creating Login class object. u can create in Login h = new Login but here we are not storing it in any variable.
    }

    public static void main(String[] args) {
        new Home(); //creating home class object. u can create in Home h = new Home but here we are not storing it in any variable.
    }
}