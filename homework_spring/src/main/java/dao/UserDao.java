package dao;

import model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserDyId(Long id);
//    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    boolean userExists(String login, String password);
}
