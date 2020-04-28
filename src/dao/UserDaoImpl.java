package dao;

import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// DAO uses JDBC(no JPA) or EntityManager(with JPA)
public class UserDaoImpl implements IUserDao {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public UserDaoImpl(){
        emf = Persistence.createEntityManagerFactory("PersistentUserPU");  
        em = emf.createEntityManager();  
    }
    
    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = em.createQuery("Select a From User a", User.class).getResultList();
        return users;
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
