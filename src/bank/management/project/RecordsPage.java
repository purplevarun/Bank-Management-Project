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
public class RecordsPage extends JFrame implements ActionListener{
    static String card;
    JButton exit,back;
    public RecordsPage(String card){
        super("Records Window");
        
        this.card=card;
           //------------------------------------------------------------------------------------
            //here we are setting size of awt window
            setLayout(null); // we can now use absolute position
            setSize(1000,800); //size of window
            setLocation(450,100); // coordinates
            getContentPane().setBackground(Color.white); // setting background color
            // all these are in javax.swing and java.awt
        //-------------------------------------------------------------------------------------
        try{
            Connector con = new Connector();
            String q = "select balance,deposit,withdraw from statement where cardno = '"+card+"'";
            ResultSet r = con.s.executeQuery(q);
            ArrayList<Integer> bal = new ArrayList<Integer>();
            ArrayList<Integer> depo = new ArrayList<Integer>();
            ArrayList<Integer> with = new ArrayList<Integer>();
            
            while(r.next()){
                bal.add(r.getInt("balance"));
                depo.add(r.getInt("deposit"));
                with.add(r.getInt("withdraw"));
            }
            System.out.println(bal);
            System.out.println(depo);
            System.out.println(with);
            int n = bal.size();
            JLabel head1 =  new JLabel("BALANCE");
            head1.setFont(new Font("helvetica",Font.BOLD,25));
            head1.setBounds(260,00,150,40);
            add(head1);
            
            JLabel head2 =  new JLabel("DEPOSIT");
            head2.setFont(new Font("helvetica",Font.BOLD,25));
            head2.setBounds(440,00,200,40);
            add(head2);
            
            JLabel head3 =  new JLabel("WITHDRAW");
            head3.setFont(new Font("helvetica",Font.BOLD,25));
            head3.setBounds(620,00,250,40);
            add(head3);
            for(int i=0;i<n;i++){
                int p=0;
                if(n<=10)
                    p=50;
                else
                    p=20;
                JLabel bali = new JLabel(""+bal.get(i)+"");
                bali.setFont(new Font("helvetica",Font.BOLD,20));
                bali.setBounds(300,10+((i+1)*p),200,40);
                add(bali);
                
                JLabel depi = new JLabel(""+depo.get(i)+"");
                depi.setFont(new Font("helvetica",Font.BOLD,20));
                depi.setBounds(480,10+((i+1)*p),200,40);
                add(depi);
                
                JLabel withi = new JLabel(""+with.get(i)+"");
                withi.setFont(new Font("helvetica",Font.BOLD,20));
                withi.setBounds(660,10+((i+1)*p),200,40);
                add(withi);
            }
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
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "error");
        }
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource()==exit){
            System.exit(0);
        }
        if(event.getSource()==back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        RecordsPage obj = new RecordsPage(card);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
