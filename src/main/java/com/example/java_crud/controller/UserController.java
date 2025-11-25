package com.example.java_crud.controller;

import com.example.java_crud.model.User;
import com.example.java_crud.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/ping")
    public String pingServer() {
        return "Server is running!";
    }
}
