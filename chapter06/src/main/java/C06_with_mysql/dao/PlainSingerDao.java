package C06_with_mysql.dao;

import C06_with_mysql.entity.Singer;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainSingerDao implements SingerDao {

    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    /////////////////////////////////////////////////////////////////////////////////////
    // DB 연결 및 연결해제
    /////////////////////////////////////////////////////////////////////////////////////

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            logger.error("MySql 데이터베이스 드라이버를 로딩할 수 없습니다!", classNotFoundException);
        }
    }

    private Connection getConnection() throws SQLException {
        String mySqlUrl = "jdbc:mysql://localhost:3306/musicdb?useSSL=true";
        String mySqlUser = "hans";
        String mySqlPassword = "1126";
        Connection connection = DriverManager.getConnection(mySqlUrl, mySqlUser, mySqlPassword);

        return connection;
    }

    private void closeConnection(Connection connection) {

        if (connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException sqlException) {
            logger.error("mySql 데이터베이스 커넥션을 닫을 때 문제가 발생하였음!", sqlException);
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    // CRUD
    /////////////////////////////////////////////////////////////////////////////////////

    @Override
    public List<Singer> findAll() {
        Connection connection = null;
        List<Singer> singers = new ArrayList<>();

        try {
            String sql = "select * from singer";

            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBirthDate(resultSet.getDate("birth_date"));
                singers.add(singer);
            }
        } catch (SQLException sqlException) {
            logger.error("SINGER - findAll : 문제 발생", sqlException);
        } finally {
            closeConnection(connection);
        }

        return singers;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;

        try {
            String sql = "insert into singer(first_name, last_name, birth_date) VALUES (?, ?, ?)";

            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, singer.getBirthDate());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                singer.setId(resultSet.getLong(1));
            }
        } catch (SQLException sqlException) {
            logger.error("SINGER - insert : 문제 발생", sqlException);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;

        try {
            String sql = "delete from singer a where a.ID = ?";

            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, singerId);
            statement.execute();
        } catch (SQLException sqlException) {
            logger.error("SINGER - delete : 문제 발생", sqlException);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findByFistName(String firstName) {
        try {
            throw new ExecutionControl.NotImplementedException("findByFirstName");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        try {
            throw new ExecutionControl.NotImplementedException("findAllWithAlbums");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String findNameById(Long id) {
        try {
            throw new ExecutionControl.NotImplementedException("findNameById");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String findLastNameById(Long id) {
        try {
            throw new ExecutionControl.NotImplementedException("findLastNameById");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String findFirstNameById(Long id) {
        try {
            throw new ExecutionControl.NotImplementedException("findFirstNameById");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Singer singer) {
        try {
            throw new ExecutionControl.NotImplementedException("update");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertWithAlbum(Singer singer) {
        try {
            throw new ExecutionControl.NotImplementedException("insertWithAlbum");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }
}
