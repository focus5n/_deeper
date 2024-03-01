package C06_with_mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainConfigTest {

    private static Logger logger = LoggerFactory.getLogger(MainConfigTest.class);

    public void test01() throws SQLException {

        // TEST
        String config = "db/driverManager-config-01.xml";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        assert (dataSource != null);
        testDataSource(dataSource);

        context.close();
    }

    private void testDataSource(DataSource dataSource) throws SQLException {
        Connection connection = null;

        try {
            String sql = "SELECT 1";

            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int mockValue = resultSet.getInt(1);
                assert (mockValue == 1);
            }

            statement.close();
        } catch (Exception e) {
            logger.error("예상치 못한 에러임...");
        } finally {
            connection.close();
        }
    }
}
