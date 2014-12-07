package db.test;

import db.test.hibernate.ConfigurationSpringHibernate;
import db.test.hibernate.oper.InsertUser;
import db.test.hibernate.oper.Tester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by karol on 04.12.14.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationSpringHibernate.class);
        Tester insertUser = applicationContext.getBean(Tester.class);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        insertUser.startThreadInserts();
//        insertUser.startThreadSelect();
        insertUser.startThreadSelect();
    }
}
