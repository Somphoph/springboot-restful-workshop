package com.example.workshop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id){
        UserResponse response = userService.getById(id);
        return response;
    }
}

/**

 {
    "id":1,
    "firstname" : "somphop",
    "lastname" : "x",
 }

 */