package com.quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame {

    String questions[][] = new String[10][5]; // 10 questions and 5 for question and 4 options for ans.
    String answers[][] = new String[10][2]; // 2 for question and its ans
    String useranswers[][] = new String[10][1]; // for 10 quetions and 1 for ans.
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions; //used for start function in checking user ansrd or not
    JButton next, submit;

    public  int timer=30; //setting timer for questions as 30 sec
    public  int ans_given=0; //using to check weather the user given ans or not
    public  int count=0; //using for question number,questions,user_ans .
    public  int score=0;// intializing socre as 0


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

        opt1 = new JRadioButton(); //creating a round button
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

        groupoptions = new ButtonGroup(); //grouping so that u can select only one option at a time
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
                ans_given=1; // if the user is clicking the nxt question that means mostly the user has ans the que

                if(groupoptions.getSelection()==null) // to check weather user selected or not
                {
                    useranswers[count][0]="";//saving 0 response

                }
                else // if selected to get the user ans
                {
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();// to get ans what user selected we use getActionCommand();
                }

                if(count==8) //count starts at 0 so 8, because we will increment 9(because after 9 we are incrementing count) and it will be 10
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
                ans_given=1; //bcz user clicks submit means he might have ans
                if(groupoptions.getSelection()==null) //we can get weather the user ansred or not. So if it is null
                {
                    useranswers[count][0]=""; //saving 0 response

                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();// to get ans what user selected we use getActionCommand();
                }

                for (int i=0;i<useranswers.length;i++) //for clac score
                {
                    if(useranswers[i][0].equals(answers[i][1])){ //validating ans
                        score+=10;// adding score
                    }
                }
                setVisible(false); //closing the frame
                new Score(score); //creating Score class object. u can create in Score h = new Score but here we are not storing it in any variable.
            }
        });
        submit.setEnabled(false); //keeping it disabled So that we make sure that the user is ans all que
        add(submit);

        start(count); //creating a function

        setVisible(true); //showing the Quiz frame
    }

    public void paint(Graphics g)
    {
        super.paint(g);//  calls the parent class's (JFrame/JPanel) paint method,super.paint(g) lays the foundation and builds the basic structure, Necessary to maintain proper graphics state

        String time = "Time Left: " +timer + "seconds";  // this is a graphic
        g.setColor(Color.RED); //to change the colour of the text we have to take the help of g(graphic class object)
        g.setFont(new Font("Tahoma", Font.BOLD, 20)); // using setFont function we created a Font classes object, same as above

        if (timer>0)
        {
            g.drawString(time, 1600, 470); //to show what string,where in X,Y.
        }
        else{
            g.drawString("Time is up!!", 1600, 470); //same as above
        }
        timer--;// it will be reduced


        try {
            Thread.sleep(1000); // So to mainting 1sec using threads.
            repaint();//paint method will be called only once if u create its object So we need to call repaint to call it again
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given==1) // if user selected ans
        {
            ans_given=0; //so track answering for next question we are making it again 0
            timer=30; // resetting the timer for nxt ques
        }
        else if (timer<0) // if timer is completed and user didn't ans
        {
            timer=30;// So 1st reset the timer
            if(count==8) //here we added because if it comes to this question because of timeup.
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9) //submit button case to make sure the quiz is submitted automatically if times is up
            {
                if(groupoptions.getSelection()==null) //we can get weather the user ansred or not. So if it is null
                {
                    useranswers[count][0]=""; //save it as empty

                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();// to get ans what user selected we use getActionCommand();
                }

                for (int i=0;i<useranswers.length;i++) //calc score
                {
                    if(useranswers[i][0].equals(answers[i][1])) //validating the ans
                    {
                        score+=10;// adding score
                    }
                }
                setVisible(false); // closing the frame
                new Score(score); //creating Score class object. u can create in Score h = new Score but here we are not storing it in any variable.

            }
            else //nextbutton case
            {
                if(groupoptions.getSelection()==null) //we can get weather the user ansred or not. So if it is null
                {
                    useranswers[count][0]=""; //save it as empty

                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand(); // to get ans what user selected we use getActionCommand();
                }
            }


            count++; //to show nxt ques
            start(count); //calling start func again for nxt que
        }
    }

    public void start(int count){
        qno.setText(" " + (count + 1) + ". "); //Since setText is a label u cant send int in that so we have to convert into string, setting question num by using count 0+1=1
        question.setText(questions[count][0]); //setting question to question from array
        opt1.setText(questions[count][1]); //setting option to opt1 from questions array
        opt1.setActionCommand(questions[count][1]); //setting value for opt1

        opt2.setText(questions[count][2]);//setting option to opt2 from questions array
        opt2.setActionCommand(questions[count][2]); //setting value for opt1

        opt3.setText(questions[count][3]);//setting option to opt3 from questions array
        opt3.setActionCommand(questions[count][3]); //setting value for opt1

        opt4.setText(questions[count][4]);//setting option to opt4 from questions array
        opt4.setActionCommand(questions[count][4]); //setting value for opt1

        groupoptions.clearSelection(); // to clear the selection for nxt question
    }

    public static void main(String[] args) {
        new Quiz();//creating Quiz class object. u can create in Quiz h = new Quiz but here we are not storing it in any variable.
    }
}
