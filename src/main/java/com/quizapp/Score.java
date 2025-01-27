package com.quizapp;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame{

    Score(int score)
    {
        setSize(400, 400);
        setLocation(800, 250);
        setLayout(null);


        JLabel heading = new JLabel("Thankyou!");
        heading.setBounds(140, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(heading);

        JLabel result = new JLabel("Your score is: " + score); // displaying score that came from quiz class
        result.setBounds(100, 150, 700, 30);
        result.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(result);

        JButton submit = new JButton("Play Again");
        submit.setBounds(150,220,100,25);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login(); // //creating Login class object. u can create in Login h = new Login but here we are not storing it in any variable.
            }
        });

        add(submit);

        setVisible(true);
    }


    public static void main(String[] args) {

        new Score(0);//creating Score class object. u can create in Score h = new Score but here we are not storing it in any variable.
    }
}