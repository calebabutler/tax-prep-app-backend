package com.skillstorm.taxprepapp;

import java.security.Principal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.skillstorm.taxprepapp.controllers.ProfileController;
import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.repositories.FinanceInfoRepository;
import com.skillstorm.taxprepapp.repositories.ProfileRepository;

@SpringBootTest
public class ProfileControllerTests {

	@Autowired
	ProfileController profileController;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    FinanceInfoRepository financeInfoRepository;
    
	private class ExamplePrincipal implements Principal {

        private String name;

        public ExamplePrincipal(String name) {
            this.name = name;
        }

		@Override
		public String getName() {
			return name;
		}

	}

    @Test
    public void testGetProfile() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testGetProfile");
        ResponseEntity<Profile> profile = profileController.getProfile(principal);
        Assertions.assertEquals(profile, ResponseEntity.badRequest().build());
    }

    @Test
    public void testCreateProfile() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();
        
        Principal principal = new ExamplePrincipal("testCreateProfile");
        Profile profile = new Profile(
            null,
            "Mary",
            null,
            "Smith",
            20010101,
            "123 Sesame St",
            "Springfield",
            "FL",
            null,
            11111,
            111111111,
            null
        );
        ResponseEntity<Void> response = profileController.createProfile(principal, profile);
        Assertions.assertEquals(response, ResponseEntity.ok().build());

        ResponseEntity<Profile> returnProfile = profileController.getProfile(principal);
        profile.setId(null);
        profile.setOauthId(null);
        Assertions.assertEquals(returnProfile, ResponseEntity.ok(profile));

        Profile changeProfile = new Profile(
            null,
            "John",
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );

        ResponseEntity<Void> changeResponse = profileController.updateProfile(principal, changeProfile);
        Assertions.assertEquals(changeResponse, ResponseEntity.ok().build());
    }

    @Test
    public void testBadCreateProfile() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testBadCreateProfile");

        Profile changeProfile = new Profile(
            null,
            "John",
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );

        ResponseEntity<Void> badChangeResponse = profileController.updateProfile(principal, changeProfile);
        Assertions.assertEquals(badChangeResponse, ResponseEntity.badRequest().build());


        Profile badProfile = new Profile(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );
        ResponseEntity<Void> badResponse = profileController.createProfile(principal, badProfile);
        Assertions.assertEquals(badResponse, ResponseEntity.badRequest().build());
    }

}
