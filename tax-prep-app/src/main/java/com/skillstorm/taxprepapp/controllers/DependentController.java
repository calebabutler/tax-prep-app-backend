package com.skillstorm.taxprepapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.taxprepapp.models.Dependent;
import com.skillstorm.taxprepapp.services.DependentService;

@RestController
@RequestMapping("/dependents")
public class DependentController extends BaseController<Dependent> {
    
    @Autowired
    void setService(DependentService service) {
        this.service = service;
    }

}
