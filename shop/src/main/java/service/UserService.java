package service;

import model.User;

import java.util.List;

public interface UserService {

    User getOne(Long id);
    List<User> findAll();
    User save(User user);
    User addUser();
    User updateUser();
    int CallableStatementExample();
}
