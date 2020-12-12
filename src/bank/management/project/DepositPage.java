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
/**
 *
 * @author purpl
 */
public class DepositPage extends JFrame implements ActionListener {
    
    JLabel enter,dep;
    JTextField amt;
    JButton deposit,exit;
    static String tempcard;
    DepositPage(String card){
        super("Deposit Window");
        tempcard=card;
        try{
        //------------------------------------------------------------------------------------
            //here we are setting size of awt window
            setLayout(null); // we can now use absolute position
            setSize(1000,800); //size of window
            setLocation(450,100); // coordinates
            getContentPane().setBackground(Color.white); // setting background color
            // all these are in javax.swing and java.awt
        //-------------------------------------------------------------------------------------
            Font f = new Font("Helvetica",Font.BOLD,55);
            enter = new JLabel("Enter the amount ");
            enter.setFont(f);
            enter.setBounds(240,100,500,60);
            add(enter);
            
            dep = new JLabel("to deposit ");
            dep.setFont(f);
            dep.setBounds(320,170,500,60);
            add(dep);
        //------------------------------------------------------------------------------------------------------    
        //------------------------------------------------------------------------------------------------------    
            amt= new JTextField();
            amt.setFont(new Font("monospaced",Font.PLAIN,40));
            amt.setBounds(340,300,250,50);
            add(amt);
        //------------------------------------------------------------------------------------------------------    
            deposit= new JButton("DEPOSIT");
            deposit.setBackground(Color.black);
            deposit.setForeground(Color.white);
            deposit.setBounds(370, 400, 200, 60);
            deposit.setFont(new Font("Arial", Font.BOLD, 35));
            add(deposit);
            deposit.addActionListener(this); // calls a method passing itself
        //------------------------------------------------------------------------------------------------------    
            exit = new JButton("EXIT");
            exit.setBackground(Color.black);
            exit.setForeground(Color.white);
            exit.setBounds(400, 650, 150, 40);
            exit.setFont(new Font("Arial", Font.BOLD, 25));
            add(exit);
            exit.addActionListener(this); // calls a method passing itself
        //------------------------------------------------------------------------------------------------------    
        }
        catch(Exception exp){
            System.out.println("error found"+exp);
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    public void actionPerformed(ActionEvent event){
        try{
            Connector con = new Connector();
            if(event.getSource()==exit){
                System.exit(0);
            }
            if(event.getSource()==deposit){
                if(amt.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter amount!");
                }
                else{
                    String x = amt.getText();
                    try{
                        int d = Integer.parseInt(x);
                        String q0 = "select balance,withdraw from statement where cardno='"+tempcard+"'";
                        ResultSet r = con.s.executeQuery(q0);
                        int bal=0,with=0;
                        while(r.next()){
                            bal = r.getInt("balance");
                            with = r.getInt("withdraw");
                        }
                        String q = "insert into statement values('"+tempcard+"','"+(bal+d)+"','"+d+"','"+0+"')";
                        con.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Money Deposited Successfully!");
                        setVisible(false);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Enter numeric value please!");
                    }
                }
            }
        }
        catch(Exception exp){
            System.out.println(exp);
            JOptionPane.showMessageDialog(null,"ERROR");
        }
    }
    public static void main(String[] args) {
        DepositPage x = new DepositPage(tempcard);
        x.setVisible(true);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
