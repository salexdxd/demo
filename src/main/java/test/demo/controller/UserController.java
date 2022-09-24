package test.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.demo.model.User;
import test.demo.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        Iterable<User> obj = userService.findAll();

        return new ResponseEntity<Object>(obj, HttpStatus.OK);
    }

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public ResponseEntity<?> homePage() {
//        Iterable<User> obj = userService.findAll();
//
//        return new ResponseEntity<Object>(obj, HttpStatus.OK);
//    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User user){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        userService.saveUser(newUser);

        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }
}
