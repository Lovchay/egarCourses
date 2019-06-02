package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserDyId(Long id);
//    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
