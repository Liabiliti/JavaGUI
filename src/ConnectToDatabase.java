/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.math.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Nicholas
 */
public class ConnectToDatabase {
    static Connection conn;
    
    public static void OpenConnection(){
    try{
        
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javauser", "root", "B!gB1ueBear");
            
            
        }catch(Exception e){System.out.println(e);}
    }
    public static void CloseConnection(){
    try{
       
        conn.close();
        
    }catch(Exception e){System.out.println(e);}
    }
    public static void Add(List<String> AddList){
     try{
         String sql = "INSERT INTO javauserdetails (Username, UserPassword, FirstName, LastName, DOB, UserType, EmailAddress, CreateDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement myStmt = conn.prepareStatement(sql);
         for (int i = 0; i < 8; i++)
         {
             myStmt.setString((i + 1) ,AddList.toArray()[i].toString());
             JOptionPane.showMessageDialog(null, AddList.toArray()[i].toString());
         }
         JOptionPane.showMessageDialog(null, myStmt);
         
         
         //myStmt.setString(1, jTextFieldUsername.getText().toString());
         
    }catch(Exception e){System.out.println(e);}
}
}