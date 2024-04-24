package com.skillstorm.taxprepapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.taxprepapp.models.AppUser;
import com.skillstorm.taxprepapp.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody AppUser user) {
        userService.register(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}
