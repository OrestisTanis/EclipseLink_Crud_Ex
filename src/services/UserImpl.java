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
        if (id <= 0 || user == null) {
            return false;
        } else {
            return userDao.update(id, user);
        }
    }

    @Override
    public int save(User user) {
        if (user == null){
            return 0;
        }
        else {
            return userDao.save(user);
        }
    }

    @Override
    public boolean deleteById(int id) {
        if (id <= 0) {
            return false;
        } else {
            return userDao.deleteById(id);
        }
    }
}
