package service.impl;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserDyId(Long id) {
        User user = userDao.getUserDyId(5L);
        return user;
    }

//    @Override
//    public synchronized boolean addUser(User user) {
//        if (userDao.userExists(user.getLogin(),user.getPassword())){
//            return false;
//        }else {
//            userDao.addUser(user);
//            return true;
//        }
//    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
