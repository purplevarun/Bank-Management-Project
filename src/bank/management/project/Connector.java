/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.project;
import java.sql.*;
/**
 *
 * @author purpl
 */
public class Connector {
    Connection c; // opens a connection with the database
    Statement s; // in order to execute SQL Queries
    public Connector(){ // constructor is public because it will be accessed by other files
        try{
            Class.forName("com.mysql.jdbc.Driver"); //initializes jdbc driver
            // also returns exception if driver not found
            // then exception is caught below and thrown
            c =DriverManager.getConnection("jdbc:mysql:///BankManagementProject","root","");    
            // connects with the database named "BankMangement" which was made in MySQL
            s =c.createStatement();
            // this statement "s" can now execute SQL Queries
        }
        catch(Exception E){
            System.out.println("There is error : "+E);
        }
    }
}
