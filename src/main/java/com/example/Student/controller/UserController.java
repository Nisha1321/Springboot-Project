package com.example.Student.controller;

import com.example.Student.model.User;
import com.example.Student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    @ResponseBody  // This ensures that the response is returned as JSON
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    @ResponseBody  // This ensures that the response is returned as JSON
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Save a new user
    @PostMapping
    @ResponseBody  // This ensures that the response is returned as JSON
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Update an existing user
    @PutMapping("/{id}")
    @ResponseBody  // This ensures that the response is returned as JSON
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    @ResponseBody  // This ensures that the response is returned as JSON
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
