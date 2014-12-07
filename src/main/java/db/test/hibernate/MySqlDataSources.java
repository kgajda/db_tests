package db.test.hibernate;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by karol on 04.12.14.
 */
@Configuration
@Profile("MySql")
public class MySqlDataSources implements DataSourcesAccess {
    private static final Logger LOGGER = LoggerFactory.getLogger(MySqlDataSources.class);

    @Override
    @Bean(destroyMethod = "close")
    public DataSource getDataSource() {
       LOGGER.info("Profile: MySql");
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setMaximumPoolSize(50);
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("");
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testy");
        hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return hikariDataSource;
    }
}
