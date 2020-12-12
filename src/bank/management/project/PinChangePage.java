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
public class PinChangePage extends JFrame implements ActionListener{
    
    static String card="";
    JButton exit,back,submit;
    JLabel old,newp,conf;
    JPasswordField ip_old,ip_newp,ip_conf;
    public PinChangePage(String card) {
        super("PIN CHANGE WINDOW");
        this.card = card;
        //------------------------------------------------------------------------------------
            //here we are setting size of awt window
            setLayout(null); // we can now use absolute position
            setSize(1000,800); //size of window
            setLocation(450,100); // coordinates
            getContentPane().setBackground(Color.white); // setting background color
            // all these are in javax.swing and java.awt
        //-------------------------------------------------------------------------------------
        
            exit = new JButton("EXIT");
            exit.setBackground(Color.black);
            exit.setForeground(Color.white);
            exit.setBounds(400, 650, 150, 40);
            exit.setFont(new Font("Arial", Font.BOLD, 25));
            add(exit);
            exit.addActionListener(this); // calls a method passing itself
            
            back = new JButton("BACK");
            back.setBackground(Color.black);
            back.setForeground(Color.white);
            back.setBounds(100, 650, 150, 40);
            back.setFont(new Font("Arial", Font.BOLD, 25));
            add(back);
            back.addActionListener(this); // calls a method passing itself
            
            submit = new JButton("SUBMIT");
            submit.setBackground(Color.black);
            submit.setForeground(Color.red);
            submit.setBounds(365, 450, 150, 40);
            submit.setFont(new Font("Arial", Font.BOLD, 25));
            add(submit);
            submit.addActionListener(this); // calls a method passing itself
            
         //-------------------------------------------------------------------------------------------------------
            Font f = new Font("Helvetica",Font.BOLD,30);
         //-------------------------------------------------------------------------------------------------------
            old = new JLabel("Enter old PIN");
            old.setFont(f);
            old.setBounds(350,00,500,40);
            add(old);
            
            newp = new JLabel("Enter new PIN");
            newp.setFont(f);
            newp.setBounds(340,150,500,40);
            add(newp);
            
            conf = new JLabel("Confirm new PIN");
            conf.setFont(f);
            conf.setBounds(320,300,500,40);
            add(conf);
         //-------------------------------------------------------------------------------------------------------
            ip_old = new JPasswordField();
            ip_old.setFont(f);
            ip_old.setBounds(390,70,90,40);
            add(ip_old);
            
            ip_newp = new JPasswordField();
            ip_newp.setFont(f);
            ip_newp.setBounds(390,220,90,40);
            add(ip_newp);
            
            ip_conf = new JPasswordField();
            ip_conf.setFont(f);
            ip_conf.setBounds(390,370,90,40);
            add(ip_conf);
         //-------------------------------------------------------------------------------------------------------
         //-------------------------------------------------------------------------------------------------------
         //-------------------------------------------------------------------------------------------------------
         //-------------------------------------------------------------------------------------------------------
         
         
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource()==exit){
            System.exit(0);
        }
        if(event.getSource()==back){
            setVisible(false);
        }
        if(event.getSource()==submit){
            try{
                String old_pin = String.valueOf(ip_old.getPassword());
                String new_pin = String.valueOf(ip_newp.getPassword());
                String new_conf = String.valueOf(ip_conf.getPassword());
                
                System.out.println("old = "+old_pin +"\nnew ="+ new_pin +"\nconf = "+ new_conf);
                
                Connector con = new Connector();
                String q = "select pin from signup2 where card = '"+card+"'";
                ResultSet r = con.s.executeQuery(q);
                int pin=0;
                
                while(r.next())
                    pin=r.getInt("pin");
                
                if(new_pin.equals(new_conf) == false)
                    JOptionPane.showMessageDialog(null,"PINs don't match !!");
                else
                {
                    int newpin = Integer.parseInt(new_pin);
                    String q1 = "select * from signup2 where card = '"+card+"'";
                    ResultSet rs = con.s.executeQuery(q1);
                    String inc="",occ="",pan="",ad="",ac="",ser="";
                    int p=0;
                    while(rs.next()){
                        inc = rs.getString("income");
                        occ = rs.getString("occupation");
                        pan = rs.getString("pan");
                        ad = rs.getString("aadhar");
                        ac = rs.getString("acc_type");
                        ser = rs.getString("services");
                        p = rs.getInt("pin");
                    }
                    String t  = "delete from signup2 where card = '"+card+"'";
                    String t1 = "delete from login where cardno = '"+card+"'";
                    con.s.executeUpdate(t);
                    con.s.executeUpdate(t1);
                    String q2 = "insert into signup2 values('"+inc+"','"+occ+"','"+pan+"','"+ad+"','"+ac+"','"+ser+"','"+newpin+"','"+card+"')";
                    con.s.executeUpdate(q2);
                    String q3 = "insert into login values('"+card+"','"+newpin+"')";
                    con.s.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null,"PIN changed successfully !");
                    setVisible(false);
                }
                
            }
            catch(Exception e){System.out.println(e);JOptionPane.showMessageDialog(null,"error");};
        }
    }
    public static void main(String[] args) {
        PinChangePage obj = new PinChangePage(card);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
