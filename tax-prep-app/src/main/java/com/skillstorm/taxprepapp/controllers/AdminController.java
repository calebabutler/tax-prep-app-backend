package com.skillstorm.taxprepapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.taxprepapp.Analytics;
import com.skillstorm.taxprepapp.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(adminService.test());
    }

    @GetMapping("/analytics")
    public ResponseEntity<Analytics> calculateAnalytics() {
        return ResponseEntity.ok(adminService.calculateAnalytics());
    }

}
