package com.skillstorm.taxprepapp.controllers;

import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.security.Principal;


@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public ResponseEntity<Profile> getProfile(Principal principal) {
        String oauthId = principal.getName();
        Optional<Profile> profile = profileService.getProfile(oauthId);
        if (profile.isPresent()) {
            return ResponseEntity.ok(profile.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Void> createProfile(Principal principal, @RequestBody Profile profile) {
        String oauthId = principal.getName();
        boolean successful = profileService.createProfile(oauthId, profile);
        if (successful) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateProfile(Principal principal, @RequestBody Profile profile) {
        String oauthId = principal.getName();
        boolean successful = profileService.updateProfile(oauthId, profile);
        if (successful) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
