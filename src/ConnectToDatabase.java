/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.math.*;
import java.util.*;
/**
 *
 * @author Nicholas
 */
public class ConnectToDatabase {
    
    public static void OpenConnection(){
    try{
            Connection conn = DriverManager.getConnection("jdbc:mysql;//localhost:3306/javauser", "root", "B!gB1ueBear");
            
            
        }catch(Exception e){System.out.println(e);}
    }
    public static void CloseConnection(){
    try{
        Connection conn = DriverManager.getConnection("jdbc:mysql;//localhost:3306/javauser", "root", "B!gB1ueBear");
        conn.close();
        
    }catch(Exception e){System.out.println(e);}
    }
    public static void Add(String sql){
     try{
        
         Connection conn = DriverManager.getConnection("jdbc:mysql;//localhost:3306/javauser", "root", "B!gB1ueBear");
         Statement myStmt = conn.createStatement();
         myStmt.executeUpdate("INSERT INTO javauserdetails " + sql);
    }catch(Exception e){System.out.println(e);}
}
}