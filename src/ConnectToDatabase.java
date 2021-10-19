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
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.lang.*;
/**
 *
 * @author Nicholas
 */
public class ConnectToDatabase extends Register{
    static Connection conn;
    static ResultSet rs;
    static String sq = new String();
    private final static Logger lgr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
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
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date parsed = format.parse(AddList.toArray()[4].toString());
         java.sql.Date setDate = new java.sql.Date(parsed.getTime());
         java.util.Date parsed2 = format.parse(AddList.toArray()[7].toString());
         java.sql.Date setDate2 = new java.sql.Date(parsed2.getTime());
         String sql = "INSERT INTO javauserdetails VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement myStmt = conn.prepareStatement(sql);
         myStmt.setString(1, AddList.toArray()[0].toString());
         myStmt.setString(2, AddList.toArray()[1].toString());
         myStmt.setString(3, AddList.toArray()[2].toString());
         myStmt.setString(4, AddList.toArray()[3].toString());
         myStmt.setDate(5, setDate);
         myStmt.setString(6, AddList.toArray()[5].toString());
         myStmt.setString(7, AddList.toArray()[6].toString());
         myStmt.setDate(8, setDate2);
         
         
//         for (int i = 0; i < 6; i++)
//         {
//             myStmt.setString((i + 1) ,AddList.toArray()[i].toString());
//         }
         int rowsInserted = myStmt.executeUpdate();
         if (rowsInserted > 0){
             JOptionPane.showMessageDialog(null, "New User Added Succesfully");
         }
         //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         //java.util.Date parsed = format.parse("20111230");
         //java.sql.Date sq1 = new java.sql.Date(parsed.getTime());
         //myStmt.setDate(0, sq1);
         
        
         
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
}
    public static void Login(List<String> lgList){
        try{
        String username = lgList.toArray()[0].toString();
        String password = lgList.toArray()[1].toString();
        String sql = "SELECT * FROM javauserdetails WHERE Username='" + username + "' and " + "UserPassword='" + password + "';";
        Statement myStmt = conn.createStatement();
        rs = myStmt.executeQuery(sql);
        if(rs.next())
        {
            JOptionPane.showMessageDialog(null, "Login Successful");
            MainMenu mm = new MainMenu();
            LoginScreen lg = new LoginScreen();
            mm.setVisible(true);
            lg.dispose();
            lg.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
        }
        
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
}
//    public static void Search(List<String> SearchList){
//        try{
//            String username = SearchList.toArray()[0].toString();
//            String emailAddress = SearchList.toArray()[6].toString();
//            String search = "SELECT * FROM javauserdetails WHERE Username='" + username + "' and " + "EmailAddress='" + emailAddress + "';";
//            Statement myStmt = conn.createStatement();
//            rs = myStmt.executeQuery(search);
//            jTableSearch
//            
//        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
//    }
//    public static void AddDate(List<String> AddDate){
//        int i = 1;
//     try{
//         String sql = "INSERT INTO javauserdetails VALUES (1, ?, ?)";
//         PreparedStatement myStmt = conn.prepareStatement(sql);
//         for (String date: AddDate)
//         {
//         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//         java.util.Date parsed = format.parse(date);
//         java.sql.Date datesql = new java.sql.Date(parsed.getTime());
//         myStmt.setDate(i, datesql);
//         i++;
//         }
//         int rowsInserted = myStmt.executeUpdate();
//         if (rowsInserted > 0){
//             JOptionPane.showMessageDialog(null, "New Dates Added Succesfully");
//         }
//         
//         //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//         //java.util.Date parsed = format.parse("20111230");
//         //java.sql.Date sq1 = new java.sql.Date(parsed.getTime());
//         //myStmt.setDate(0, sq1);  
//    }catch(Exception e){System.out.println(e);}
//    }
     public static void Update(String us, String pf, String fn, String ln, String rd, String cbut, String em, String cd){
    //Logger x = ConnectToDatabase.setLogger("updateLog.txt");
         try{
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date parsed = format.parse(rd);
         java.sql.Date setDate = new java.sql.Date(parsed.getTime());
         java.util.Date parsed2 = format.parse(cd);
         java.sql.Date setDate2 = new java.sql.Date(parsed2.getTime());
    
         sq = "UPDATE javauserdetails SET"; //UserPassword='" + pf + "', FirstName='" + fn + "', LastName='" + ln +"', DOB='" + setDate + "', UserType='" + cbut + "', EmailAddress='" + em + "', CreateDate='" + setDate2 + "' WHERE Username='" + us +"'";
         if (pf.isEmpty() == false && pf != null)
         {
             sq = sq + " UserPassword='" + pf;
         }
         if (fn.isEmpty() == false && fn != null)
         {
             sq = sq +"', FirstName='" + fn;
         }
         if (ln.isEmpty() == false && ln != null)
         {
             sq = sq + "', LastName='" + ln;
         }
         if (rd.isEmpty() == false && rd != null)
         {
             sq = sq + "', DOB='" + setDate;
         }
         if (cbut.isEmpty() == false && cbut != null)
         {
             sq = sq + "', UserType='" + cbut;
         }
         if (em.isEmpty() == false && em != null)
         {
             sq = sq + "', EmailAddress='" + em;
         }
         if (cd.isEmpty() == false && cd != null)
         {
             sq = sq + "', CreateDate='" + setDate2 + "' WHERE Username='" + us +"';";
         }
         if ((sq.indexOf(",") == 27 && sq.indexOf("'") == 26))
         {
             sq = sq.replaceFirst(",", "");
             sq = sq.replaceFirst("'", "");
         }
         // Lines 144-177: Allow the user information to be updated regardless of what's filled in or not, leading the already existing information to not go null   
        
         PreparedStatement myStmt = conn.prepareStatement(sq);
         int rowsInserted = myStmt.executeUpdate();
         if (rowsInserted > 0){
             JOptionPane.showMessageDialog(null, "User Updated Succesfully");
         }
         //x.log(Level.INFO, "Error Report");
         //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         //java.util.Date parsed = format.parse("20111230");
         //java.sql.Date sq1 = new java.sql.Date(parsed.getTime());
         //myStmt.setDate(0, sq1);
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    //{x.log(Level.WARNING, "Error testing connection", e);}
}
     public static void Delete(String us, String up){
         try{
         String sql = "DELETE FROM javauserdetails WHERE Username=? AND UserPassword=?";
         PreparedStatement myStmt = conn.prepareStatement(sql);
         myStmt.setString(1, us);
          myStmt.setString(2, up);
         int rowsDeleted = myStmt.executeUpdate();
         if (rowsDeleted > 0){
             JOptionPane.showMessageDialog(null, "User Deleted Succesfully");    
         }
         else{
             JOptionPane.showMessageDialog(null, "User was unable to be deleted");
         }
         }catch (Exception e){JOptionPane.showMessageDialog(null, "Unable to delete");}
     }
     public static Logger setLogger (String FileName)
     {
         LogManager.getLogManager().reset();
         lgr.setLevel(Level.ALL);
                try {
			FileHandler Fh = new FileHandler(FileName);
                        Fh.setLevel(Level.ALL);
                        lgr.addHandler(Fh);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}            
                return lgr;
    }
     
}