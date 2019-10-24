
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *////

/**
 *
 * @author hp
 */
public class productframe {
    conn cn = new conn();
public void addproduct(String prname, int prqty, int prprice){
    int z = 0;
     String sql= "insert into product_info values (null,?,?,?)";
try{
     Class.forName(cn.driver);
     Connection con = DriverManager.getConnection(cn.url,cn.username,cn.password);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, prname);
        ps.setInt(2, prqty);
        ps.setInt(3, prprice);
        ps.executeUpdate();
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(productframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productframe.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void delete(int id){
        try { 
            Class.forName(cn.driver);
            Connection con = DriverManager.getConnection(cn.url,cn.username,cn.password);
            PreparedStatement ps = con.prepareStatement("Delete from product_info where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productframe.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void editQuantity(int id, int quantity){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(cn.url,cn.username,cn.password);
            PreparedStatement ps = con.prepareStatement("update product_info set quantity = quantity + ? where id = ?");
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productframe.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
