/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ntbngoc.data.dao;

import ntbngoc.data.model.User;

/**
 *
 * @author Admin
 */
public interface UserDao {
    public User findUser(String emailphone, String password);
}
