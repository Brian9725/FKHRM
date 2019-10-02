/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 8:13
 */
package pers.brian.hrm.dao;

import pers.brian.hrm.dao.Provider.UserDynaSQLProvider;
import pers.brian.hrm.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//该类仅用于开发时测试数据库
public class DaoTest {
    private static String DRIVER = null;
    private static String URL = null;
    private static String USER = null;
    private static String PASSWORD = null;

    public static void init() {
        //从db.properties中读取数据库配置
        Properties properties = new Properties();
        try {
            InputStream inputStream = DaoTest.class.getResourceAsStream("/db.properties");
            properties.load(inputStream);
            DRIVER = (String) properties.get("dataSource.driverClass");
            URL = (String) properties.get("dataSource.jdbcUrl");
            USER = (String) properties.get("dataSource.user");
            PASSWORD = (String) properties.get("dataSource.password");
            //System.out.println(DRIVER);
            //System.out.println(URL);
            //System.out.println(USER);
            //System.out.println(PASSWORD);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User user = null;
        DaoTest.init();
        //无法将admin和123456赋给SQL语句中的参数
        String tempSql = new UserDynaSQLProvider().selectByLoginnameAndPassword("admin", "123456");
        System.out.println(tempSql);
        Connection connection = DaoTest.getConnection();
        //System.out.println(connection);
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(tempSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setLoginname(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setStatus(resultSet.getInt(4));
                user.setCreateDate(resultSet.getDate(5));
                user.setUsername(resultSet.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user.getLoginname());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
    }
}
