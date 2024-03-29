package C06_with_mysql;

import com.mysql.cj.xdevapi.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "C06_with_mysql")
@EnableTransactionManagement
public class HibernateConfig {

    private static Logger logger = LoggerFactory.getLogger(HibernateConfig.class);

    @Bean
    public DataSource dataSource() {

        try {
            String schemaClassPath = "classpath:sql/schema.sql";
            String sqlClassPath = "classpath:sql/test-data.sql";

            EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
            return databaseBuilder
                    .setType(EmbeddedDatabaseType.H2)
                    .addScripts(schemaClassPath, sqlClassPath)
                    .build();
        } catch (Exception exception) {
            logger.error("임베디드 DataSource 빈을 생성할 수 없음.");
            return null;
        }
    }

    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.format_sql", true);
        hibernateProp.put("hibernate.use_sql_comments", true);
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }
}
