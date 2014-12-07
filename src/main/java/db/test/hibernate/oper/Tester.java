package db.test.hibernate.oper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * Created by karol on 06.12.14.
 */
@Component
public class Tester {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private ApplicationContext applicationContext;

    public void startThreadInserts() {
        for (int i = 0; i < 100; i++) {
            InsertUser insertUser = applicationContext.getBean(InsertUser.class);
            threadPoolTaskExecutor.execute(insertUser);
        }
    }
    public void startThreadSelect() {
        for (int i = 0; i < 50; i++) {
            SelectUser insertUser = applicationContext.getBean(SelectUser.class);
            threadPoolTaskExecutor.execute(insertUser);
        }
    }

}
