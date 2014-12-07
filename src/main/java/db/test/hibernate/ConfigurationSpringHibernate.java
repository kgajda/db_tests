package db.test.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by karol on 04.12.14.
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "db.test.hibernate")
public class ConfigurationSpringHibernate {


    @Autowired
    private DataSourcesAccess dataSource;

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource.getDataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan("db.test.hibernate.orm");
        sessionFactory.afterPropertiesSet();
        return sessionFactory.getObject();
    }

    private Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.connection.autocommit", "false");
        properties.put("hibernate.hbm2ddl.auto", "validate");

//        properties.put("hibernate.hikari.dataSource.cachePrepStmts", "true");
//        properties.put("hibernate.hikari.dataSource.prepStmtCacheSize", "250");
//        properties.put("hibernate.hikari.dataSource.prepStmtCacheSqlLimit", "2048");
//        properties.put("hibernate.hikari.dataSource.useServerPrepStmts", "true");

        //second level cache
        properties.put("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
        properties.put("hibernate.cache.use_query_cache", "true");
        properties.put("hibernate.max_fetch_depth", "4");
        properties.put("hibernate.cache.use_second_level_cache", "true");
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.put("net.sf.ehcache.configurationResourceName", "ehcache.xml");
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;

    }

    @Bean
    ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setQueueCapacity(1000);
        threadPoolTaskExecutor.setCorePoolSize(50);
        threadPoolTaskExecutor.setMaxPoolSize(50);
        return threadPoolTaskExecutor;
    }
}