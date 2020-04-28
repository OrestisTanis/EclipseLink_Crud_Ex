/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.util.List;

/**
 *
 * @author Walter
 */
public interface IUserDao {
    User findById(int id);
    
    List<User> findAll();
    
    boolean update(int id, User user);
    
    int save(User user);
    
    boolean deleteById(int id);
}
