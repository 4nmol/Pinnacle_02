import java.awt.*;  
import java.awt.event.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class QuizTest extends JFrame implements ActionListener
{
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    
     QuizTest(String s) {
            super(s);
            label = new JLabel();
            add(label);
            bg=new ButtonGroup();
            for(int i=0;i<5;i++){
                radioButtons[i]=new JRadioButton();
                add(radioButtons[i]);
                bg.add(radioButtons[i]);
            }
            btnNext=new JButton("Next");
            btnResult=new JButton("Result");
            btnResult.setVisible(false);
            btnResult.addActionListener(this);
            btnNext.addActionListener(this);
            add(btnNext);
            add(btnResult);
            setData();
            label.setBounds(30,40,450,20);
            radioButtons[0].setBounds(50,80,450,20);
            radioButtons[1].setBounds(50,110,200,20);
            radioButtons[2].setBounds(50,140,200,20);
            radioButtons[3].setBounds(50,170,200,20);
            btnNext.setBounds(100,240,100,30);
            btnResult.setBounds(270,240,100,30);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            setLocation(250,100);
            setVisible(true);
            setSize(600,350);
            
            
            
        }
        
        void setData(){
            radioButtons[4].setSelected(true);
            if(current==0){
                label.setText("Question 1:Which is official app for Android app development");
                radioButtons[0].setText("Java");
                radioButtons[1].setText("Kotlin");
                radioButtons[2].setText("C++");
                radioButtons[3].setText("Javascript");
                // Java
            }
             if(current==1){
                label.setText("Question 2:What is Size of boolean variable");
                radioButtons[0].setText("8-bits");
                radioButtons[1].setText("16-bits");
                radioButtons[2].setText("32-bits");
                radioButtons[3].setText("None");
                // 16 bits
            }
             if(current==2){
                label.setText("Question 3:What is the default value of long variable");
                radioButtons[0].setText("0");
                radioButtons[1].setText("0.0");
                radioButtons[2].setText("0L ");
                radioButtons[3].setText("No known");
                // 0L
            }
             if(current==3){
                label.setText("Question 4:what is the default value of Boolean variable");
                radioButtons[0].setText("true");
                radioButtons[1].setText("false");
                radioButtons[2].setText("null");
                radioButtons[3].setText("not defined");
                // false
            }
             if(current==4){
                label.setText("Question 5:What kind of variable a class can consist of");
                radioButtons[0].setText("class variable,instance variable");
                radioButtons[1].setText("class variable,instance variable,local variable");// answer
                radioButtons[2].setText("class variable");
                radioButtons[3].setText("class variable,local variable");
                
            }
             if(current==5){
                label.setText("Question 6:What is function overloading");
                radioButtons[0].setText("Methods with same name but different parameters ");// answer
                radioButtons[1].setText("Methods with same name but different return types");
                radioButtons[2].setText("Methods with same name ,same parameters type but different parameter name");
                radioButtons[3].setText("None of this or None of above");
                
            }
             if(current==6){
                label.setText("Question 7:what is serialization");
                radioButtons[0].setText("serialization is the Process of writing the state of an object into another object");
                radioButtons[1].setText("serialization is the Process of writing the state of an object into byt stream");// answer
                radioButtons[2].setText("Both of the above");
                radioButtons[3].setText("None of the above");
                
            }
             if(current==7){
                label.setText("Question 8:Which of the following is the thread safe");
                radioButtons[0].setText("String Builder");
                radioButtons[1].setText("String Buffer ");// answer
                radioButtons[2].setText("Both of above");
                radioButtons[3].setText("None of above");
                
            }
             if(current==8){
                label.setText("Question 9:Who is founder of java ");
                radioButtons[0].setText("James Gosling");// answer
                radioButtons[1].setText("Undertaker");
                radioButtons[2].setText("Bruce Lee");
                radioButtons[3].setText("John cena");
                
            }
             if(current==9){
                label.setText("Question 10:Which of the following is type of languange ");
                radioButtons[0].setText("Java,kotlin,javascript");
                radioButtons[1].setText("HTML,CSS,PHP,DBMS");
                radioButtons[2].setText("C++,C,Python");
                radioButtons[3].setText("All of the above");
                
            }
            label.setBounds(30,40,450,20);
            for(int i=0,j=0;i<=90;i+=30,j++){
                radioButtons[j].setBounds(50,80+i,200,20);
                
            }
        }
        boolean checkans(){
            if(current==0)
            {
                return (radioButtons[0].isSelected());
            }
            if(current==1)
            {
                return (radioButtons[1].isSelected());
            } 
            if(current==2)
            {
                return (radioButtons[2].isSelected());
            }
            if(current==3)
            {
                return (radioButtons[1].isSelected());
            }
            if(current==4)
            {
                return (radioButtons[1].isSelected());
            }
              if(current==5)
            {
                return (radioButtons[0].isSelected());
            }
              if(current==6)
            {
                return (radioButtons[1].isSelected());
            }
              if(current==7)
            {
                return (radioButtons[1].isSelected());
            }
              if(current==8)
            {
                return (radioButtons[0].isSelected());
            }
              if(current==9)
            {
                return (radioButtons[3].isSelected());
            }
            
            
            return false;
        }
        
    public static void main (String[] args) {
       new QuizTest("Simple Quiz app");
    }
    
   @Override
   public void actionPerformed(ActionEvent e) {
      // throw new UnsupportedOperationException("Not supported yet.");
      if(e.getSource()==btnNext){
          if(checkans())
            count=count+1;
          current++;
          setData();
          if(current==9){
              btnNext.setEnabled(false);
              btnResult.setVisible(true);
              btnResult.setText("Result");
              
          }
      }
      if(e.getActionCommand().equals("Result")){
          if(checkans())
            count=count+1;
          current++;
          JOptionPane.showMessageDialog(this,"Correct answers are"+count);
          System.exit(0);
      }
   }
}