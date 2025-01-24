package com.quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{

    JTextField tfname,tfempid;
    JButton login, close;

    Home() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Quiz App");
        heading.setBounds(200, 60, 100, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(175, 140, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(Color.BLACK);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(175, 160, 180, 25);
        tfname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tfname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfempid.requestFocusInWindow();
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
        tfempid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.requestFocusInWindow();
            }
        });
        add(tfempid);

        login = new JButton("Login");
        login.setBounds(175,260,80,25);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLogin();
            }
        });
        add(login);

        close = new JButton("Close");
        close.setBounds(275,260,80,25);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(close);

        setSize(500, 500);
        setLocation(350, 250);
        setVisible(true);
    }

    public void openLogin(){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Home();
    }
}