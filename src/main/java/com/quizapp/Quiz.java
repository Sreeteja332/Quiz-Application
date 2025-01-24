package com.quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;

    public static int timer=30;
    public static int ans_given=0;
    public static int count=0;
    public static int score=0;


    Quiz(){
        setBounds(0,0,1927,1035);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("Quiz");
        title.setBounds(900, 60, 700, 50);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        add(title);

        JLabel stitle = new JLabel("All the best!");
        stitle.setBounds(880, 135, 500  , 30);
        stitle.setFont(new Font("Arial", Font.BOLD, 30));
        stitle.setForeground(Color.BLACK);
        add(stitle);

        qno=new JLabel();
        qno.setFont(new Font("Arial",Font.BOLD,20));
        qno.setBounds(50,300,50,30);
        qno.setForeground(Color.BLACK);
        add(qno);

        question = new JLabel();
        question.setBounds(150, 300, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "What color is a banana?";
        questions[0][1] = "Red";
        questions[0][2] = "Yellow";
        questions[0][3] = "Blue";
        questions[0][4] = "Green";

        questions[1][0] = "How many legs does a dog have?";
        questions[1][1] = "3";
        questions[1][2] = "4";
        questions[1][3] = "2";
        questions[1][4] = "5";

        questions[2][0] = "What is the first letter of the alphabet?";
        questions[2][1] = "B";
        questions[2][2] = "C";
        questions[2][3] = "A";
        questions[2][4] = "D";

        questions[3][0] = "Which animal says 'Meow'?";
        questions[3][1] = "Dog";
        questions[3][2] = "Cat";
        questions[3][3] = "Horse";
        questions[3][4] = "Cow";

        questions[4][0] = "What is 2 + 2?";
        questions[4][1] = "3";
        questions[4][2] = "5";
        questions[4][3] = "4";
        questions[4][4] = "6";

        questions[5][0] = "What color is the sky on a clear day?";
        questions[5][1] = "Green";
        questions[5][2] = "Red";
        questions[5][3] = "Blue";
        questions[5][4] = "Yellow";

        questions[6][0] = "How many days are in a week?";
        questions[6][1] = "5";
        questions[6][2] = "6";
        questions[6][3] = "7";
        questions[6][4] = "8";

        questions[7][0] = "What is the capital of the United States?";
        questions[7][1] = "New York";
        questions[7][2] = "Los Angeles";
        questions[7][3] = "Washington D.C.";
        questions[7][4] = "Chicago";

        questions[8][0] = "Which fruit is red and round?";
        questions[8][1] = "Banana";
        questions[8][2] = "Apple";
        questions[8][3] = "Grape";
        questions[8][4] = "Orange";

        questions[9][0] = "What is the largest animal?";
        questions[9][1] = "Cat";
        questions[9][2] = "Dog";
        questions[9][3] = "Elephant";
        questions[9][4] = "Mouse";

        answers[0][1] = "Yellow";
        answers[1][1] = "4";
        answers[2][1] = "A";
        answers[3][1] = "Cat";
        answers[4][1] = "4";
        answers[5][1] = "Blue";
        answers[6][1] = "7";
        answers[7][1] = "Washington D.C.";
        answers[8][1] = "Apple";
        answers[9][1] = "Elephant";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 420, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 460, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 500, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 540, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1600, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
                ans_given=1;

                if(groupoptions.getSelection()==null)
                {
                    useranswers[count][0]="";

                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                }

                if(count==8)
                {
                    next.setEnabled(false);
                    submit.setEnabled(true);
                }

                count++;
                start(count);
            }
        });
        add(next);


        submit = new JButton("Submit");
        submit.setBounds(1600, 630, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ans_given=1;
                if(groupoptions.getSelection()==null)
                {
                    useranswers[count][0]="";

                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                }

                for (int i=0;i<useranswers.length;i++)
                {
                    if(useranswers[i][0].equals(answers[i][1])){
                        score+=10;
                    }
                }
                setVisible(false);
                new Score(score);
            }
        });
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time Left: " +timer + "seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if (timer>0)
        {
            g.drawString(time, 1600, 470);
        }
        else{
            g.drawString("Time is up!!", 1600, 470);
        }
        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given==1){
            ans_given=0;
            timer=30;
        }
        else if (timer<0){
            timer=30;
            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9)
            {
                if(groupoptions.getSelection()==null)
                {
                    useranswers[count][0]="";

                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                }

                for (int i=0;i<useranswers.length;i++)
                {
                    if(useranswers[i][0].equals(answers[i][1])){
                        score+=10;
                    }
                }
                setVisible(false);
                new Score(score);

            }
            else{
                if(groupoptions.getSelection()==null)
                {
                    useranswers[count][0]="";

                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                }
            }


            count++;
            start(count);
        }
    }

    public void start(int count){
        qno.setText(" " + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
