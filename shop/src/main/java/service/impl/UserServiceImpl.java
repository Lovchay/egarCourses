package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import org.apache.derby.client.am.SqlException;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getOne(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public  User addUser() {
        try {
            return userDao.addUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser() {
        try{
            return userDao.updateUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int CallableStatementExample() {
        try{
            return  userDao.CallableStatementExample();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
