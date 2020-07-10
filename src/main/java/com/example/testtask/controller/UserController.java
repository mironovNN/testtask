package com.example.testtask.controller;

import com.example.testtask.model.User;
import com.example.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> view(@PathVariable(name = "id") int id) {
        final User user = userService.view(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> change(@PathVariable(name = "id") int id, @RequestBody User user) {
        final boolean changed = userService.change(user, id);
        return changed
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
