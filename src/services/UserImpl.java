package services;

import dao.UserDaoImpl;
import entities.User;
import java.util.List;

public class UserImpl implements IUser {
    UserDaoImpl userDao;
    
    public UserImpl(){
        // DAO = Data Access Object
        userDao = new UserDaoImpl();
    }
    

    @Override
    public User findById(int id) {
        if (id <= 0) {
            return null;
        } else {
            return userDao.findById(id);
        }
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean update(int id, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
