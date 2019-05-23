package dao;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    User getOne(Long id);
    List<User> findAll();
    User save(User user);
    User addUser() throws SQLException;
    User updateUser () throws SQLException;
    int CallableStatementExample() throws SQLException;
}
