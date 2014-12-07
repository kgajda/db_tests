package db.test.hibernate.oper;

import db.test.hibernate.dao.UserDAO;
import db.test.hibernate.orm.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by karol on 04.12.14.
 */
@Component
@Scope("prototype")
public class InsertUser implements Runnable {
    @Autowired
    private UserDAO userDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(InsertUser.class);
    private static int i = 0;

    public void run() {
        upI();
        LOGGER.info("Start UserInsert {}", i);
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName(String.valueOf(i));
            user.setSourname(String.valueOf(i));
            user.setType(String.valueOf(i));
            long start = System.currentTimeMillis();
            userDAO.insert(user);
            long time = System.currentTimeMillis() - start;
            LOGGER.info("Insert : time: {}", time);
        }
        LOGGER.info("End UserInsert");
    }

    private synchronized void upI() {
        i++;
    }
}
