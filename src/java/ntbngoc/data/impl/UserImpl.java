/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntbngoc.data.impl;

import java.sql.Connection;
import ntbngoc.data.dao.UserDao;
import ntbngoc.data.driver.MySQLDriver;
import ntbngoc.data.model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class UserImpl implements UserDao {
    Connection con = MySQLDriver.getConnection();

    @Override
    public User findUser(String emailphone, String password){
        String sql;
        if(emailphone.contains("@"))sql="select * from users where email='"+emailphone+"and password='"+password+"'";
        else sql="select * from users where phone='"+emailphone+"and password='"+password+"'";
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
                if(rs.next()) return new User(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
