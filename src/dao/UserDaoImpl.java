package dao;

import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// DAO uses JDBC-SQL statements(no JPA) or EntityManager(with JPA)
public class UserDaoImpl implements IUserDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDaoImpl() {
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
    public boolean updateById(int id, User user) {
        User oldUser = em.find(User.class, id);
        if (oldUser != null) {
            em.getTransaction().begin();
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            oldUser.setTel(user.getTel());
            oldUser.setEmail(user.getEmail());
            em.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return 1;
    }

    @Override
    public boolean deleteById(int id) {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
            em.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }
}
