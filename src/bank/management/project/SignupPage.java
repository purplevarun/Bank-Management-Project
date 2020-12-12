/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author purpl
 */
public class SignupPage extends JFrame implements ActionListener{
    
    JLabel heading,page1,name,date,gender,father_name,email,address,pincode,label_credits;
    JTextField name_value,fathername_value,email_value,address_value,pincode_value;
    JRadioButton male,female; // create MCQ option type input
    JButton btn_submit,exit; //clickable button
    JComboBox day,month,year; // dropdown input menu
    
    //-------GENERATING RANDOM NUMBER OF 4 DIGITS FOR FORM NUMBER---------
    Random ran = new Random();
    int ran1 = (ran.nextInt()%9000) + 1000;
    int r = Math.abs(ran1);
    //----------------------------------------------------------------------
    
    SignupPage(){ // non-parameterized constructor
        super("New Bank Account Form Page 1"); //title of the window
        try{
            //------------------------------------------------------------------------------------
            //here we are setting size of awt window
            setLayout(null); // we can now use absolute position
            setSize(1000,800); //size of window
            setLocation(450,100); // coordinates
            getContentPane().setBackground(Color.white); // setting background color
            // all these are in javax.swing and java.awt
            //-------------------------------------------------------------------------------------
            //------------------LABEL--------------------
            heading = new JLabel("APPLICATION NO. "+r);
            heading.setFont(new Font("Serif", Font.BOLD, 45));
            heading.setBounds(220,0,800,50);
            add(heading);
            
            page1 = new JLabel("Page 1 : Personal Details");
            page1.setBounds(340,50,800,50);
            page1.setFont(new Font("Serif", Font.BOLD, 30));
            add(page1);
            
            name = new JLabel("Name : ");
            name.setBounds(100,120,800,50);
            name.setFont(new Font("Serif", Font.BOLD, 30));
            add(name);
            
            father_name = new JLabel("Father Name : ");
            father_name.setBounds(100,190,800,50);
            father_name.setFont(new Font("Serif", Font.BOLD, 30));
            add(father_name);
            
            date = new JLabel("Date : ");
            date.setBounds(100,260,800,50);
            date.setFont(new Font("Serif", Font.BOLD, 30));
            add(date);
            
            gender = new JLabel("Gender : ");
            gender.setBounds(100,330,800,50);
            gender.setFont(new Font("Serif", Font.BOLD, 30));
            add(gender);
            
            email = new JLabel("Email : ");
            email.setBounds(100,400,800,50);
            email.setFont(new Font("Serif", Font.BOLD, 30));
            add(email);
            
            address = new JLabel("Address : ");
            address.setBounds(100,470,800,50);
            address.setFont(new Font("Serif", Font.BOLD, 30));
            add(address);
            
            pincode = new JLabel("Pincode : ");
            pincode.setBounds(100,540,800,50);
            pincode.setFont(new Font("Serif", Font.BOLD, 30));
            add(pincode);
            
            label_credits = new JLabel("Project by Varun Kedia"); // varun kedia(ME!!) text
            label_credits.setFont(new Font("Monospaced",Font.ITALIC, 20));
            label_credits.setBounds(700, 630, 300, 200);
            add(label_credits);
            //-------------------------------------------------------------------------------------
            //------------TEXT FIELDS------------
            name_value = new JTextField("");
            name_value.setBounds(350, 125, 500, 40);
            name_value.setFont(new Font("monospaced",Font.BOLD,30));
            add(name_value);
            
            fathername_value = new JTextField("");
            fathername_value.setBounds(350, 195, 500, 40);
            fathername_value.setFont(new Font("monospaced",Font.BOLD,30));
            add(fathername_value);
            
                    
            String days[] = new String[31];
            for(int i=1;i<=31;i++){
                days[i-1]=String.valueOf(i);
            }
            day = new JComboBox(days);
            day.setBackground(Color.WHITE);
            day.setBounds(350,270,50,30);
            day.setFont(new Font("SansSerif",Font.PLAIN,20));
            add(day);
            
            String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
            month = new JComboBox(months);
            month.setBounds(470,270,120,30);
            month.setBackground(Color.WHITE);
            month.setFont(new Font("SansSerif",Font.PLAIN,20));
            add(month);
        
            String years0[] = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002"};
            String[] years = new String[years0.length];
            for(int i=years0.length-1,j=0;i>=0;i--){
                years[j++] = years0[i];
            }
            year = new JComboBox(years);
            year.setBounds(650,270,100,30);
            year.setFont(new Font("SansSerif",Font.PLAIN,20));
            year.setBackground(Color.WHITE);
            add(year);
            
            male = new JRadioButton("Male");
            male.setFont(new Font("Raleway", Font.BOLD, 14));
            male.setBackground(Color.WHITE);
            male.setBounds(350,330,100,50);
            male.setFont(new Font("SansSerif",Font.PLAIN,20));
            male.setSelected(true); // yes selected
            add(male);
        
            female = new JRadioButton("Female");
            female.setFont(new Font("Raleway", Font.BOLD, 14));
            female.setBackground(Color.WHITE);
            female.setBounds(480,330,150,50);
            female.setFont(new Font("SansSerif",Font.PLAIN,20));
            female.setSelected(false); // not selected
            add(female);
            
            email_value = new JTextField("");
            email_value.setBounds(350, 405, 500, 40);
            email_value.setFont(new Font("monospaced",Font.BOLD,30));
            add(email_value);
            
            address_value = new JTextField("");
            address_value.setBounds(350, 475, 500, 40);
            address_value.setFont(new Font("monospaced",Font.BOLD,30));
            add(address_value);
            
            pincode_value = new JTextField("");
            pincode_value.setBounds(350, 545, 500, 40);
            pincode_value.setFont(new Font("monospaced",Font.BOLD,30));
            add(pincode_value);
            //------------------------------------------------------------
            //-----------BUTTONS------------------
            exit = new JButton("EXIT");
            exit.setBackground(Color.black);
            exit.setForeground(Color.white);
            exit.setBounds(400, 650, 150, 40);
            exit.setFont(new Font("Arial", Font.BOLD, 25));
            add(exit);
            exit.addActionListener(this); // calls a method passing itself
            
            
            btn_submit = new JButton("NEXT");
            btn_submit.setBackground(Color.black);
            btn_submit.setForeground(Color.white);
            btn_submit.setBounds(750, 650, 150, 40);
            btn_submit.setFont(new Font("Arial", Font.BOLD, 25));
            add(btn_submit);
            btn_submit.addActionListener(this); // calls a method passing itself
        }
        catch(Exception exp){
            System.out.println("There is one error = "+exp);
            JOptionPane.showMessageDialog(null,"ERROR!");
        }
    }
    @Override
    public void actionPerformed(ActionEvent event){
       try{
           Connector conn = new Connector();
           String name_str = name_value.getText();
           String fathername_str = fathername_value.getText();
           
           String day_str = (String)day.getSelectedItem();
           String month_str = (String)month.getSelectedItem();
           String year_str = (String)year.getSelectedItem();
           
           String gender_str=null; // to be set 
           
           if(male.isSelected()){
               gender_str = "male";
               
           }
           if(female.isSelected()){
               gender_str = "female";               
           }
           String email_str = email_value.getText();
           String address_str = address_value.getText();
           String pincode_str= pincode_value.getText();
           
           if(event.getSource()==exit){
               System.exit(0);
           }
           
           if(event.getSource()==btn_submit){
               //System.out.println("ssup");
               //System.out.println("name="+name_str);
               if(name_str.equals("") || fathername_str.equals("") || email_str.equals("") || address_str.equals("") || pincode_str.equals("")){
                   System.out.println("problem"); 
                   JOptionPane.showMessageDialog(null,"Fill all Fields Please !!");
                }
                else{
                    // name of table is "signup"
                        System.out.println("no prob");
                        String query = "insert into signup values('"+r+"','"+name_str+"','"+fathername_str+"', '"+email_str+"' , '"+address_str+"' , '"+pincode_str+"' , '"+day_str+"' , '"+month_str+"' , '"+year_str+"' , '"+gender_str+"')";
                        conn.s.executeUpdate(query);
                        new SignupPage2().setVisible(true);
                        setVisible(false);

                }
           }
       } 
       catch(Exception exp){
           System.out.println("error is here - "+exp);
           JOptionPane.showMessageDialog(null,"ERROR!");
       }
    }
    public static void main(String[] args) {
        SignupPage obj = new SignupPage();
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //System.exit(0);
    }
}
