/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.project;

import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *
 * @author purpl
 */
public class abt extends JFrame implements ActionListener{
    JButton back,exit;
    abt(){
        super("ABOUT PAGE");
        
          //here we are setting size of awt window
            setLayout(null); // we can now use absolute position
            setSize(1000,800); //size of window
            setLocation(450,100); // coordinates
            getContentPane().setBackground(Color.white); // setting background color
            // all these are in javax.swing and java.awt
        
        
        JLabel data = new JLabel("Bank Management Project");
        data.setFont(new Font("serif",Font.BOLD,40));
        data.setBounds(250,-300,700,700);
        add(data);
        
        JLabel data1 = new JLabel("Made by Varun Kedia");
        data1.setFont(new Font("serif",Font.BOLD,40));
        data1.setBounds(250,-200,700,700);
        add(data1);
        
        JLabel data2 = new JLabel("Asansol Engineering College");
        data2.setFont(new Font("serif",Font.BOLD,40));
        data2.setBounds(250,-100,900,700);
        add(data2);
        
        JLabel data3 = new JLabel("IT - 5th Semester");
        data3.setFont(new Font("serif",Font.BOLD,40));
        data3.setBounds(250,00,700,700);
        add(data3);
        
        JLabel data4 = new JLabel("Started : 16th November 2020");
        data4.setFont(new Font("serif",Font.BOLD,40));
        data4.setBounds(250,100,700,700);
        add(data4);
        
        JLabel data5 = new JLabel("Ended : 22th November 2020");
        data5.setFont(new Font("serif",Font.BOLD,40));
        data5.setBounds(250,200,700,700);
        add(data5);
        
          exit = new JButton("EXIT");
            exit.setBackground(Color.black);
            exit.setForeground(Color.white);
            exit.setBounds(400, 650, 150, 40);
            exit.setFont(new Font("Arial", Font.BOLD, 25));
            add(exit);
            exit.addActionListener(this); // calls a method passing itself\
            
          back = new JButton("BACK");
            back.setBackground(Color.black);
            back.setForeground(Color.white);
            back.setBounds(100, 650, 150, 40);
            back.setFont(new Font("Arial", Font.BOLD, 25));
            add(back);
            back.addActionListener(this); // calls a method passing itself
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==exit){
            System.exit(0);
        }
        if (e.getSource()==back){
            new LoginPage().setVisible(true);
            setVisible(false);
            return;
        }
    }
    public static void main(String[] args) {
        new abt().setVisible(true);
        return;
    }
}
