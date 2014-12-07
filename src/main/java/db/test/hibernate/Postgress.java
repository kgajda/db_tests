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
@Profile("Postgres")
public class Postgress implements DataSourcesAccess{

    private static final Logger LOGGER = LoggerFactory.getLogger(MySqlDataSources.class);

    @Override
    @Bean(destroyMethod = "close")
    public DataSource getDataSource() {
        LOGGER.info("Profile: Postgres");
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setMaximumPoolSize(50);
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("postgres");
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/testy");
        hikariDataSource.setDriverClassName("org.postgresql.Driver");
        return hikariDataSource;
    }
}
