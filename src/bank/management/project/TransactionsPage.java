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
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author purpl
 */
public class TransactionsPage extends JFrame implements ActionListener{

        JLabel balance,heading;
        JButton exit;
        JButton records,deposit,withdraw,pin_change,bal_btn;
       static  String tempcard = "";
    TransactionsPage(String card){
        
        super("Transaction Window");
        JOptionPane.showMessageDialog(null, "Login Successful !!");
        System.out.println(card);
        tempcard = card;
        try{
            //------------------------------------------------------------------------------------
            //here we are setting size of awt window
            setLayout(null); // we can now use absolute position
            setSize(1000,800); //size of window
            setLocation(450,100); // coordinates
            getContentPane().setBackground(Color.white); // setting background color
            // all these are in javax.swing and java.awt
        //-------------------------------------------------------------------------------------
            Font f = new Font("Helvetica",Font.BOLD,40);
            heading = new JLabel("Welcome to ATM");
            heading.setFont(f);
            heading.setBounds(300,0,400,40);
            add(heading);
            
            Font font = new Font("helvetica",Font.BOLD,30);
            balance = new JLabel("Your account balance = ");
            balance.setFont(font);
            balance.setBounds(100,100,350,40);
            add(balance);
            
            exit = new JButton("EXIT");
            exit.setBackground(Color.black);
            exit.setForeground(Color.white);
            exit.setBounds(400, 650, 150, 40);
            exit.setFont(new Font("Arial", Font.BOLD, 25));
            add(exit);
            exit.addActionListener(this); // calls a method passing itself
        //---------------------------------------------------------------------
        //---------------------------------------------------------------------
            deposit = new JButton("DEPOSIT");
            deposit.setBackground(Color.black);
            deposit.setForeground(Color.white);
            deposit.setFont(font);
            deposit.setBounds(100,200,350,80);
            add(deposit);
            deposit.addActionListener(this);
            
            bal_btn = new JButton("Click here to see balance");
            bal_btn.setBackground(Color.white);
            bal_btn.setForeground(Color.black);
            bal_btn.setFont(font);
            bal_btn.setBounds(450,78,450,80);
            add(bal_btn);
            bal_btn.addActionListener(this);
            
            records = new JButton("CHECK RECORDS");
            records.setBackground(Color.black);
            records.setForeground(Color.white);
            records.setFont(font);
            records.setBounds(100,400,350,80);
            add(records);
            records.addActionListener(this);
            
            withdraw = new JButton("WITHDRAW");
            withdraw.setBackground(Color.black);
            withdraw.setForeground(Color.white);
            withdraw.setFont(font);
            withdraw.setBounds(550,200,350,80);
            add(withdraw);
            withdraw.addActionListener(this);
            
            pin_change = new JButton("CHANGE PIN");
            pin_change.setBackground(Color.black);
            pin_change.setForeground(Color.white);
            pin_change.setFont(font);
            pin_change.setBounds(550,400,350,80);
            add(pin_change);
            pin_change.addActionListener(this);
        
        //---------------------------------------------------------------------
        //---------------------------------------------------------------------
        
            
        }
        catch(Exception exp){
            System.out.println("the error is here ---->"+exp);
            JOptionPane.showMessageDialog(null,"ERROR!");
        }
    }
    
    public void actionPerformed(ActionEvent event){
        try{
            Connector con = new Connector();
            int bal = -1;
            String fetching_balance = "select balance from statement where cardno='"+tempcard+"'";
            ResultSet bal_set = con.s.executeQuery(fetching_balance);
            while(bal_set.next())
                bal = bal_set.getInt("balance");
            System.out.println("this is balance "+bal);
            if(event.getSource()==bal_btn){
                JOptionPane.showMessageDialog(null, "This is your balance: \n"+bal);
                
            }
            if(event.getSource()==deposit){
                new DepositPage(tempcard).setVisible(true);
                //setVisible(false);
            }
            if(event.getSource()==withdraw){
                new WithdrawPage(tempcard).setVisible(true);
            }
            if(event.getSource()==records){
                new RecordsPage(tempcard).setVisible(true);
            }
            if(event.getSource()==pin_change){
                new PinChangePage(tempcard).setVisible(true);
            }
            if(event.getSource()==exit){
                //System.out.println("this is card = "+tempcard);
                System.exit(0);
            
            }
        }
        catch(Exception exp){System.out.println("error caught = "+exp);JOptionPane.showMessageDialog(null,"ERROR!");}
    }
    
    public static void main(String[] args) {
        TransactionsPage obj = new TransactionsPage(tempcard);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
