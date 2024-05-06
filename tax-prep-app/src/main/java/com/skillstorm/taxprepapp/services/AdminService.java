package com.skillstorm.taxprepapp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String test() {
        return "I am an admin!";
    }

}
