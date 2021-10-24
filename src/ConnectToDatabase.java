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
        Logger x = ConnectToDatabase.setLogger("Connection.txt");
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javauser", "root", "B!gB1ueBear"); //Opens a connection with the Database
            
            x.log(Level.INFO, "Connection Completed"); //If successful will send the file Connection.txt the details of when the connection occurred
        }catch(Exception e) {
            x.log(Level.WARNING, "Error connecting to Database"); //If unsuccessful will send to the Connection.txt, there was an error with details.
        }
    }
    public static void CloseConnection(){
    try{
       
        conn.close(); //Closes the connection to the database
        
    }catch(Exception e){System.out.println(e);}
    }
    public static void Add(List<String> AddList){
     Logger x = ConnectToDatabase.setLogger("NewUser.txt");
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
         
         int rowsInserted = myStmt.executeUpdate();
         if (rowsInserted > 0){
             JOptionPane.showMessageDialog(null, "New User Added Succesfully"); //This function allows for the addition of new users to the database
             x.log(Level.INFO, "New User Added Successfully"); 
         }
         
    }
     catch (NullPointerException e) {JOptionPane.showMessageDialog(null, "All boxes must be filled");}
     catch(Exception e)
     { 
         x.log(Level.WARNING, "Error Adding User");
     }
}
    public static void Login(List<String> lgList){
        Logger x = ConnectToDatabase.setLogger("Login.txt");
        
        try{
        String username = lgList.toArray()[0].toString();
        String password = lgList.toArray()[1].toString();
        String sql = "SELECT * FROM javauserdetails WHERE Username='" + username + "' and " + "UserPassword='" + password + "';";
        Statement myStmt = conn.createStatement();
        rs = myStmt.executeQuery(sql); //This function checks if the username and passsword supplied are already in the database, if they are and match each other the user will be allowed to log in
        if(rs.next())
        {
            JOptionPane.showMessageDialog(null, "Login Successful");
            MainMenu mm = new MainMenu();
            LoginScreen lg = new LoginScreen();
            mm.setVisible(true);
            lg.dispose();
            lg.setVisible(false);
            x.log(Level.INFO, "Login Connection Successful");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
        }
        
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);
            x.log(Level.WARNING, "Error Logging in");}
}

     public static void Update(String us, String pf, String fn, String ln, String rd, String cbut, String em, String cd){
    
         try{
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date parsed = format.parse(rd);
         java.sql.Date setDate = new java.sql.Date(parsed.getTime());
         java.util.Date parsed2 = format.parse(cd);
         java.sql.Date setDate2 = new java.sql.Date(parsed2.getTime());
    
         sq = "UPDATE javauserdetails SET"; 
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
//         
         if (cd.isEmpty() == false && cd != null)
         {
             sq = sq + "', CreateDate='" + setDate2 + "' WHERE Username='" + us +"' OR EmailAddress='" + em +"';";
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
         else 
         {
            JOptionPane.showMessageDialog(null, "User was unable to be deleted, are you sure you have the right Email/Username?");
         }
         
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
   
}
     public static void Delete(String us, String up){
         try{
         String sql = "DELETE FROM javauserdetails WHERE Username=? OR EmailAddress=?";
         PreparedStatement myStmt = conn.prepareStatement(sql);
         myStmt.setString(1, us);
          myStmt.setString(2, up);
         int rowsDeleted = myStmt.executeUpdate();
         if (rowsDeleted > 0){
             JOptionPane.showMessageDialog(null, "User Deleted Succesfully");    // If the username or email matches those that are in the database than on completion those users will be deleted.
         }
         else{
             JOptionPane.showMessageDialog(null, "User was unable to be deleted");
         }
         }catch (Exception e){JOptionPane.showMessageDialog(null, "Unable to delete, are you sure you have the right Email/Username?");}
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
		}            //A logger class that allows the creation of textfiles to log specific functions during the application
                return lgr;
    }
     
}