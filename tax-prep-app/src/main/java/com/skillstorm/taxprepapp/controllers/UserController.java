package com.skillstorm.taxprepapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.taxprepapp.models.User;
import com.skillstorm.taxprepapp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User> {

    @Autowired
    void setService(UserService service) {
        this.service = service;
    }

}
