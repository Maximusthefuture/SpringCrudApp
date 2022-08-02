package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("delete from User where id=: id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<User> listUsers() {
       return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
