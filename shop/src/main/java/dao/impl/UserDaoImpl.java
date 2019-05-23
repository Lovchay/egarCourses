package dao.impl;

import dao.UserDao;
import jdbc.ServerConnector;
import jdbc.ServerQuery;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getOne(Long id) {

        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        User user = new User();

        try {
            String query = ServerQuery.getInstance().getQuery("getOneUser");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setNickName(resultSet.getString(4));
                user.setBasketId(resultSet.getLong(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            close(preparedStatement, resultSet);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        try {
            String query = ServerQuery.getInstance().getQuery("getAllUsers");
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setNickName(resultSet.getString(4));
                user.setBasketId(resultSet.getLong(5));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User addUser() throws SQLException {
        Statement statement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        statement = connection.createStatement();

        try{
            statement.executeUpdate("INSERT INTO user(id,login,password,nickname,basket_id) values('3','vvv','bbb','3')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser() throws SQLException {
        Statement statement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        statement = connection.createStatement();
        try {
            statement.executeUpdate("update user set login = 'ooo' where id = 3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int CallableStatementExample() throws SQLException {
        CallableStatement callableStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();


            callableStatement = connection.prepareCall("{? = call fun(?,?)}");
            callableStatement.registerOutParameter(1,Types.INTEGER);
            callableStatement.setInt(2,2);
            callableStatement.setInt(3,3);
            ResultSet resultSet = callableStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
    }

    private void close(PreparedStatement preparedStatement, ResultSet resultSet) {

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
