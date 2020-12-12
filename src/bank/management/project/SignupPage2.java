/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.project;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author purpl
 */
public class SignupPage2 extends JFrame implements ActionListener{
        
        JLabel label_credits,page2,religion,income,occupation,panno,aadharno,acc_type,services_reqd;
        JTextField pan_no,aadhar_no;
        JComboBox income_ip,occupation_ip;
        JRadioButton savings,fixed,current;
        JCheckBox sms,internet,atm,accept;
        JButton exit,btn_submit;
    SignupPage2(){
        super("New Bank Account Form Page 2");
        try{
        //------------------------------------------------------------------------------------
            //here we are setting size of awt window
            setLayout(null); // we can now use absolute position
            setSize(1000,800); //size of window
            setLocation(450,100); // coordinates
            getContentPane().setBackground(Color.white); // setting background color
            // all these are in javax.swing and java.awt
        //-------------------------------------------------------------------------------------
        //-------------J-LABELS------------------------------------------------------    
            page2 = new JLabel("Page 2 : Account Details");
            page2.setBounds(340,0,800,50);
            page2.setFont(new Font("Serif", Font.BOLD, 30));
            add(page2);
            
            label_credits = new JLabel("Project by Varun Kedia"); // varun kedia(ME!!) text
            label_credits.setFont(new Font("Monospaced",Font.ITALIC, 20));
            label_credits.setBounds(700, 630, 300, 200);
            add(label_credits);
            
            income = new JLabel("Annual Income :");
            income.setBounds(100,80,800,50);
            income.setFont(new Font("Serif", Font.BOLD, 30));
            add(income);
            
            occupation = new JLabel("Occupation :");
            occupation.setBounds(100,150,800,50);
            occupation.setFont(new Font("Serif", Font.BOLD, 30));
            add(occupation);
            
            panno = new JLabel("Pan Number :");
            panno.setBounds(100,220,800,50);
            panno.setFont(new Font("Serif", Font.BOLD, 30));
            add(panno);
            
            aadharno = new JLabel("Aadhar Number :");
            aadharno.setBounds(100,290,800,50);
            aadharno.setFont(new Font("Serif", Font.BOLD, 30));
            add(aadharno);
            
            acc_type = new JLabel("Account Type :");
            acc_type.setBounds(100,360,800,50);
            acc_type.setFont(new Font("Serif", Font.BOLD, 30));
            add(acc_type);
            
            services_reqd = new JLabel("Services Required :");
            services_reqd.setBounds(100,440,800,50);
            services_reqd.setFont(new Font("Serif", Font.BOLD, 30));
            add(services_reqd);
        //--------------------COMBOBOX--------------------------------------
            String incomearr[] = {"None","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
            income_ip = new JComboBox(incomearr);
            income_ip.setBackground(Color.WHITE);
            income_ip.setFont(new Font("Raleway", Font.BOLD, 14));
            income_ip.setBounds(400,90,150,30);
            add(income_ip);
        
            String occupationarr[] = {"Student","Unemployed","Salaried","Business","Retired"};
            occupation_ip = new JComboBox(occupationarr);
            occupation_ip.setBackground(Color.WHITE);
            occupation_ip.setFont(new Font("Raleway", Font.BOLD, 14));
            occupation_ip.setBounds(400,160,150,30);
            add(occupation_ip);
        //----------------------------------------------------
        
        //-------------TEXT FIELDS-----------------
            pan_no = new JTextField("");
            pan_no.setBounds(400,230,300,30);
            pan_no.setFont(new Font("monospaced", Font.BOLD, 20));
            add(pan_no);
            
            aadhar_no = new JTextField("");
            aadhar_no.setBounds(400,300,300,30);
            aadhar_no.setFont(new Font("monospaced", Font.BOLD, 20));
            add(aadhar_no);
            
        //------------------------------------------------------
        //------------------ACCOUNTS TYPE - JRADIO-------------------
            savings = new JRadioButton("Savings");
            savings.setFont(new Font("Raleway", Font.BOLD, 24));
            savings.setBackground(Color.WHITE);
            savings.setBounds(400,365,120,50);
            add(savings);
            
            current = new JRadioButton("Current");
            current.setFont(new Font("Raleway", Font.BOLD, 24));
            current.setBackground(Color.WHITE);
            current.setBounds(550,365,120,50);
            add(current);
            
            fixed = new JRadioButton("Fixed Deposit");
            fixed.setFont(new Font("Raleway", Font.BOLD, 24));
            fixed.setBackground(Color.WHITE);
            fixed.setBounds(700,365,300,50);
            add(fixed);
            
        //------------------------------------------------------
            sms = new JCheckBox("SMS Alerts");
            sms.setFont(new Font("Raleway", Font.BOLD, 22));
            sms.setBackground(Color.WHITE);
            sms.setBounds(400,440,150,50);
            add(sms);
            
            internet = new JCheckBox("Internet Banking");
            internet.setFont(new Font("Raleway", Font.BOLD, 22));
            internet.setBackground(Color.WHITE);
            internet.setBounds(550,440,220,50);
            add(internet);
            
            atm = new JCheckBox("ATM Card");
            atm.setFont(new Font("Raleway", Font.BOLD, 22));
            atm.setBackground(Color.WHITE);
            atm.setBounds(780,440,150,50);
            add(atm);
            
            accept = new JCheckBox("I Accept and Declare that I have read all the terms and conditions properly.");
            accept.setFont(new Font("Raleway", Font.BOLD, 22));
            accept.setBackground(Color.WHITE);
            accept.setBounds(100,540,1000,50);
            add(accept);
//---------------------------------------------------------
        //----------------------------------------------------------
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
        //------------------------------------------------------------
        }
        catch(Exception exp){System.out.println("THERE IS ERROR"+exp);JOptionPane.showMessageDialog(null,"ERROR!");}
        
    }
    public void actionPerformed(ActionEvent event){
        
        try{
        
            String str_income = (String)income_ip.getSelectedItem();
            String str_occupation = (String)occupation_ip.getSelectedItem();
            String str_pan = pan_no.getText();
            String str_aadhar = aadhar_no.getText();
            String str_type = "";
        
            if(savings.isSelected()){
                str_type = "Savings";
            }
            else if(fixed.isSelected()){
                str_type = "Fixed Deposit";
            }
            else if(current.isSelected()){
                str_type = "Current";
            }
            else str_type = "";
        
            String str_services="";
            if(sms.isSelected())
                str_services+="SMS, ";
            if(internet.isSelected())
                str_services+="Internet Banking, ";
            if(atm.isSelected())
                str_services+="ATM Card ";
            //--------------------------------------------------
            //------CREATION OF ATM PIN AND CARD NUMBER----------------
                int pin0 = (int)(Math.random()*10000);
                System.out.println("random = "+pin0);
                String pin = String.valueOf(pin0);
                int one = (int)(Math.random()*10000);
                int two = (int)(Math.random()*10000);
//                int three = (int)(Math.random()*10000);
//                int four = (int)(Math.random()*10000);
                String card = "XXXXXXXX" +  String.valueOf(one) + String.valueOf(two);
                System.out.println("card = "+card);
            //--------------------------------------------------
            
            if(event.getSource()==btn_submit){
                if(accept.isSelected()){
                    //System.exit(0);
                    Connector conn = new Connector();
                    String query1 = "insert into signup2 values('"+str_income+"','"+str_occupation+"','"+str_pan+"','"+str_aadhar+"','"+str_type+"','"+str_services+"','"+pin+"','"+card+"')";                                           
                    String query2 = "insert into login values('"+card+"','"+pin+"')";
                    String query3 = "insert into statement values('"+card+"','"+0+"','"+0+"','"+0+"')";
                    conn.s.executeUpdate(query1); // signup2 updated
                    conn.s.executeUpdate(query2); //  login updated
                    conn.s.executeUpdate(query3); // saved data into new account database
                    JOptionPane.showMessageDialog(null,"Please note your credentials :\n"+"Card No. = "+card+"\nPin = "+pin);                                             
                    
                    new LoginPage().setVisible(true);
                    setVisible(false);
                }
                else
                    //System.out.println("Please agree to terms and conditions");
                    JOptionPane.showMessageDialog(null,"Please agree to terms and conditions");
            }
            if(event.getSource()==exit){
                System.exit(0);
            }
        }
        catch(Exception exp){System.out.println("ERROR -> "+exp);JOptionPane.showMessageDialog(null,"ERROR!");}
    }
    public static void main(String[] args) {
        SignupPage2 obj = new SignupPage2();
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
