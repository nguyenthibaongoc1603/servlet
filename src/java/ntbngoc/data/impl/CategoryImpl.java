/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntbngoc.data.impl;

import java.util.List;
import ntbngoc.data.dao.CategoryDao;

import ntbngoc.data.model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ntbngoc.data.driver.MySQLDriver;

/**
 *
 * @author Admin
 */
public class CategoryImpl implements CategoryDao {
    Connection con = MySQLDriver.getConnection();
    @Override
    public List<Category> findALL(){
        List<Category> listCategory = new ArrayList<>();
        String sql ="select * from categories";
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                listCategory.add(new Category(id, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategory;
    }
    @Override
    public boolean insert(Category category){
        return true;
    }
    @Override
    public boolean update(Category category){
        return true;
    }
    @Override
    public boolean delete(int id){
        return true;
    }
    @Override
    public Category find(int id){
        return null;
    }
}
