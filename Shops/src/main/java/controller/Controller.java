package controller;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    public UserDao dao;

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        List<User> users = dao.findAll();
        return users;
    }
}
