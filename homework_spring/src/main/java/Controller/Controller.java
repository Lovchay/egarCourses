package Controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.UserService;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("user")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("article/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserDyId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("articles")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list,HttpStatus.OK);
    }

//    @PostMapping("users")
//    public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder){
//        boolean flag = userService.addUser(user);
//        if (flag == false){
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(user.getId()));
//        return new ResponseEntity<>(headers, HttpStatus.CREATED);
//    }

    @PutMapping("article")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("article/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
