package com.example.tpcours4.controllers;

import com.example.tpcours4.models.User;
import com.example.tpcours4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/users")
    public List<User> list()
    {
        return userRepository.findAll();
    }
    @GetMapping
    @RequestMapping("/api/user/{id}")
    public User get(@PathVariable Long id)
    {
        return userRepository.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user)
    {
        return userRepository.saveAndFlush(user);
    }
}
