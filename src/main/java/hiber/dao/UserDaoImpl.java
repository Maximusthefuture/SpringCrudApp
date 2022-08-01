package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void delete(long id) {
       Query query = sessionFactory.getCurrentSession().createQuery("delete User where id=:id");
       query.setParameter("id", id);
       query.executeUpdate();
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void update(long id) {
        User user = findById(id);
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User findById(long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }
}
