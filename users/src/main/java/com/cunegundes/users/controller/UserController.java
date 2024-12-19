package com.cunegundes.users.controller;

import com.cunegundes.users.database.models.User;
import com.cunegundes.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // @GetMapping("/{username}")
    // public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
    //     return ResponseEntity.ok(userService.getUserByUsername(username));
    // }
    //
    // @GetMapping("/{email}")
    // public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
    //     return ResponseEntity.ok(userService.getUserByEmail(email));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
