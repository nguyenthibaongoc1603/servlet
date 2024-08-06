/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntbngoc.data.dao;

import ntbngoc.data.impl.CategoryImpl;
import ntbngoc.data.impl.ProductImpl;
import ntbngoc.data.impl.UserImpl;

/**
 *
 * @author Admin
 */
public class Database {
    public static CategoryDao getCategoryDao(){
        return new CategoryImpl();
    }
     public static ProductDao getProductDao(){
        return new ProductImpl();
    }
     public static UserDao getUserDao(){
        return new UserImpl();
    }
}
