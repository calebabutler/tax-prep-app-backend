package com.skillstorm.taxprepapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.services.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController extends BaseController<Profile> {

    @Autowired
    void setService(ProfileService service) {
        this.service = service;
    }

}
