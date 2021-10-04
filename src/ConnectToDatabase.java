/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.math.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
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
         String sql = "INSERT INTO javauserdetails VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement myStmt = conn.prepareStatement(sql);
         for (int i = 0; i < 8; i++)
         {
             myStmt.setString((i + 1) ,AddList.toArray()[i].toString());
         }
         int rowsInserted = myStmt.executeUpdate();
         if (rowsInserted > 0){
             JOptionPane.showMessageDialog(null, "New User Added Succesfully");
         }
         //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         //java.util.Date parsed = format.parse("20111230");
         //java.sql.Date sq1 = new java.sql.Date(parsed.getTime());
         //myStmt.setDate(0, sq1);
         
        
         
    }catch(Exception e){System.out.println(e);}
}
    public static void AddDate(List<String> AddDate){
        int i = 1;
     try{
         String sql = "INSERT INTO javauserdetails VALUES (1, ?, ?)";
         PreparedStatement myStmt = conn.prepareStatement(sql);
         for (String date: AddDate)
         {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date parsed = format.parse(date);
         java.sql.Date datesql = new java.sql.Date(parsed.getTime());
         myStmt.setDate(i, datesql);
         i++;
         }
         int rowsInserted = myStmt.executeUpdate();
         if (rowsInserted > 0){
             JOptionPane.showMessageDialog(null, "New Dates Added Succesfully");
         }
         
         //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         //java.util.Date parsed = format.parse("20111230");
         //java.sql.Date sq1 = new java.sql.Date(parsed.getTime());
         //myStmt.setDate(0, sq1);  
    }catch(Exception e){System.out.println(e);}
    }
}