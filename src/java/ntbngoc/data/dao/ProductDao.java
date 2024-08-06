/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ntbngoc.data.dao;

import java.util.List;
import ntbngoc.data.model.Product;

/**
 *
 * @author Admin
 */
public interface ProductDao {
    public List<Product> findAll();
}
