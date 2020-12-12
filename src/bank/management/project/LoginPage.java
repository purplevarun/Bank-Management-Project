/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.project;

import java.awt.*; // to create a GUI
import java.sql.*; 
import java.awt.event.*; // for managing event like mouse click, keypress in the GUI model
import javax.swing.*; // built on top of AWT and provides components for GUI

/**
 *
 * @author purpl
 */

// JFrame class belongs to javax.swing and creates a GUI window
// ActionListener interface responds to actions like mouse click and keyboard input
public class LoginPage extends JFrame implements ActionListener{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//--------------------------GLOBAL VARIABLES--------------------------------
        JLabel label_welcome,label_cardno,label_pin,label_credits; // jlabel is a class inside javax.swing and displays a short string
        JTextField txtfield_input; // creates input box for input
        JPasswordField passfield_password; // create input box for astrerik input
        JButton btn_signup,btn_signin,exit,abt; // creates clickable button
        // all these are inside java.swing
    //---------------------------------------------------------------------------
    LoginPage(){ //constructor
        
        super("Bank Management System"); // this will be the title of the jframe
        //THIS HAS TO BE THE FIRST STATEMENT INSIDE THE CONSTRUCTOR
        
        try{
            //------------------------------------------------------------------------------------
            //here we are setting size of awt window
            setLayout(null); // we can now use absolute position
            setSize(1000,800); //size of window
            setLocation(450,100); // coordinates
            getContentPane().setBackground(Color.white); // setting background color
            // all these are in javax.swing and java.awt
                        
            //------------------------LABELS---------------------------------------------------
            label_welcome = new JLabel("Welcome to Bank Management Project"); // heading of page
            label_welcome.setFont(new Font("Osward",Font.BOLD, 45)); //properties of the text
            label_welcome.setBounds(100,-100,850,500); // positioning
            add(label_welcome); // adding to window (MOST IMPORTANT) //java.awt class

            label_cardno = new JLabel("Enter Card No. :"); // card number text
            label_cardno.setFont(new Font("Osward",Font.BOLD, 35));
            label_cardno.setBounds(100,200,375,200);
            add(label_cardno);

            label_pin = new JLabel("Enter PIN :"); // enter pin text
            label_pin.setFont(new Font("Osward",Font.BOLD, 35));
            label_pin.setBounds(100,330,375,200);
            add(label_pin);

            label_credits = new JLabel("Project by Varun Kedia"); // varun kedia(ME!!) text
            label_credits.setFont(new Font("Monospaced",Font.ITALIC, 20));
            label_credits.setBounds(700, 630, 300, 200);
            add(label_credits);
            
            //-------------INPUT FIELDS-------------------------------------------
            txtfield_input = new JTextField(16); // taking input of card number
            txtfield_input.setBounds(400, 275, 375, 50);
            txtfield_input.setFont(new Font("monospaced",Font.BOLD, 35));
            add(txtfield_input);
            
            passfield_password = new JPasswordField(4); // taking input of pin
            passfield_password.setBounds(400,410,100,50);
            passfield_password.setFont(new Font("monospaced",Font.BOLD, 35));
            add(passfield_password);
            //----------BUTTONS----------------------------------------------------
            btn_signin = new JButton("SIGN IN"); //sign in button
            btn_signin.setBackground(Color.black);
            btn_signin.setForeground(Color.white);
            btn_signin.setBounds(250, 550, 150, 40);
            btn_signin.setFont(new Font("Arial", Font.BOLD, 25));
            add(btn_signin);
            btn_signin.addActionListener(this); // calls method passing itself //this method performs task of button
            
            btn_signup = new JButton("SIGN UP"); // sign up button
            btn_signup.setBackground(Color.black);
            btn_signup.setForeground(Color.white);
            btn_signup.setBounds(550, 550, 150, 40);
            btn_signup.setFont(new Font("Arial", Font.BOLD, 25));
            add(btn_signup);
            btn_signup.addActionListener(this); // calls a method passing itself
            
            exit = new JButton("EXIT");
            exit.setBackground(Color.black);
            exit.setForeground(Color.white);
            exit.setBounds(400, 650, 150, 40);
            exit.setFont(new Font("Arial", Font.BOLD, 25));
            add(exit);
            exit.addActionListener(this); // calls a method passing itself
            //---------------------------------------------------------------------
            
            abt = new JButton("ABOUT");
            abt.setBackground(Color.black);
            abt.setForeground(Color.white);
            abt.setBounds(00, 700, 130, 30);
            abt.setFont(new Font("Arial", Font.BOLD, 20));
            add(abt);
            abt.addActionListener(this); // calls a method passing itself
        }
        catch(Exception exp){
            System.out.println("There was a problem with the Application!!"+exp);
            JOptionPane.showMessageDialog(null,"ERROR!");
        }
    }
    //this method is invoked whenever an action occurs (ie)you click on a GUI component.
    //it is the only abstract method in the ActionListener interface
    @Override
    public void actionPerformed(ActionEvent event){ // ActionEvent is a class inside java.awt.event
        try{
            Connector conn = new Connector(); // object of Connector class
            String cardno = txtfield_input.getText();
            String pass = passfield_password.getText();
//            String pass = new String(passfield_password.getPassword());
            String query1 = "select * from login where cardno = '"+cardno+"' and password = '"+pass+"'";
            // this query1 is used to access the "login" database
            ResultSet rs = conn.s.executeQuery(query1); // table of data representing the database
            if(event.getSource()==abt){
                new abt().setVisible(true);
            }
            if(event.getSource()==exit){
                System.exit(0);
            }
            if(event.getSource()==btn_signin){ // when signin button was clicked
                if(rs.next()){ //checks if card no. and password match
                    new TransactionsPage(cardno).setVisible(true); //displays transaction window
                    //setVisible(false); // hides current window
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
                }
            }
            if(event.getSource()==btn_signup){ // when signup button is clicked
                //JOptionPane.showMessageDialog(null, "ssup");
                new SignupPage().setVisible(true);
                setVisible(false);
                
            }
        }
        catch(Exception e){
            System.out.println("There was an error !!"+e);
            JOptionPane.showMessageDialog(null,"ERROR!");
            
        }
    } 
    public static void main(String[] args) {
        LoginPage obj = new LoginPage();
        obj.setVisible(true); // this method makes the JFrame appear on screen
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so that close button stops the application

    }
}
