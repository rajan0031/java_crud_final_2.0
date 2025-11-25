package com.example.java_crud.controller;

import com.example.java_crud.model.User;
import com.example.java_crud.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

   // start ----  this is just for the simple check
    @GetMapping("/ping")
    public String pingServer() {
        return "Server is running!";
    }

    // end ----- this is the just for the simle check

    @GetMapping("/all")
    public List<User> getAllUser(){
        return service.getAllUser();
    }

    // update the user details here 
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
    return service.updateUser(id, user);
    }

}
