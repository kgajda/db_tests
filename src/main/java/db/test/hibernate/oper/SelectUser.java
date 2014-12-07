package db.test.hibernate.oper;

import db.test.hibernate.dao.UserDAO;
import db.test.hibernate.orm.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by karol on 06.12.14.
 */
@Component
@Scope("prototype")
public class SelectUser implements Runnable{

    @Autowired
    private UserDAO userDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectUser.class);
    private static int i = 0;

    public void run() {
        upI();
        LOGGER.info("Start SelectUser {}", i);
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            userDAO.selectId(i);
            long time = System.currentTimeMillis() - start;
            LOGGER.info("Select : time: {}", time);
        }
        LOGGER.info("End SelectUser");
    }

    private synchronized void upI() {
        i++;
    }
}
