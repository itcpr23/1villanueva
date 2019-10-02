
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class loginclass1 {
    protected String driver = "com.mysql.jdbc.Driver";
    protected String url = "jdbc:mysql://localhost/villanueva_reg?";
     protected String username = "root";
     protected String password = ""; 
     
     public int enter(String uname,String pass){ int x=0;
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = con.prepareStatement("select * from registration where username = ? and password = md5(?)");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                x=1;
            }
            else{
                x=-1;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginclass1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginclass1.class.getName()).log(Level.SEVERE, null, ex);
        }return x;
     }
     
     
}
