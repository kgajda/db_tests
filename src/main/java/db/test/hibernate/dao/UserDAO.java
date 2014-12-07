package db.test.hibernate.dao;

import db.test.hibernate.orm.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karol on 04.12.14.
 */
@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

    @Transactional
    public void insert(User user) {
//        long start = System.currentTimeMillis();
        sessionFactory.getCurrentSession().save(user);
//        long time = System.currentTimeMillis() - start;
//        LOGGER.info("Insert in Transaction: {} ,hash {},time: {}",user.toString(),user.hashCode(),time);
    }
    @Transactional(readOnly = true)
    public void selectId(int name) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE name = :name");
        query.setParameter("name",String.valueOf(name));
        List<User> userList = query.setCacheable(true).list();
//        LOGGER.info("select result {} ",userList.size());
    }
}
