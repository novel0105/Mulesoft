/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Novel VM
 */
public class DBConnect {
    public static Connection myConn=null;
    public static String sqliteserver="jdbc:sqlite:";
    public static String resetpath="";
    
    public static boolean isDatabaseExists(String dbfilepath)
    {
        File dbfile=new File(dbfilepath);
        return dbfile.exists();
    }
    public static Connection getConnection()
    {
        sqliteserver="jdbc:sqlite:";
        String getFilePath=new File("").getAbsolutePath();
        String fileabsoutepath=getFilePath.concat("\\src\\src\\database\\Movies.db");
        
        if(isDatabaseExists(fileabsoutepath))
        {
            try {
                Class.forName("org.sqlite.JDBC");
                myConn=DriverManager.getConnection(sqliteserver+fileabsoutepath);
                System.out.println("Connection Successfull");
            } catch (Exception ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            createDBFile("database","Movies");
            try {
                Class.forName("org.sqlite.JDBC");
                myConn=DriverManager.getConnection(sqliteserver+fileabsoutepath);
                System.out.println("Connection Successfull");
            } catch (Exception ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return myConn;
    }
    public static void createDBFile(String filesubfolder,String filename)
    {
        String getFilePath=new File("").getAbsolutePath();
        String fileABsolutePath=getFilePath.concat("\\src\\src\\"+filesubfolder+"\\"+filename+".db");
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con=DriverManager.getConnection(sqliteserver+fileABsolutePath);
            if(con!=null)
            {
                
                DatabaseMetaData meta=con.getMetaData();
                String sql="create table Movies (MovieName varchar(50),Actor Varchar(50),Actress varchar(50),Year varchar(10),Director varchar(50));";
                Statement st=con.createStatement();
                st.executeUpdate(sql);
                
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
}
