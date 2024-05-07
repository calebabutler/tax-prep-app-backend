package com.skillstorm.taxprepapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.skillstorm.taxprepapp.controllers.AdminController;
import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.repositories.FinanceInfoRepository;
import com.skillstorm.taxprepapp.repositories.ProfileRepository;

@SpringBootTest
public class AdminControllerTests {

    @Autowired
    AdminController adminController;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    FinanceInfoRepository financeInfoRepository;

    @Test
    public void testTest() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User user = new User("test", "test", authorities);
        SecurityContext ctx = SecurityContextHolder.createEmptyContext();
        ctx.setAuthentication(new UsernamePasswordAuthenticationToken(user, null, authorities));
        SecurityContextHolder.setContext(ctx);
        Assertions.assertEquals(adminController.test(), ResponseEntity.ok("I am an admin!"));
        SecurityContextHolder.clearContext();
    }

    @Test
    public void testAnalytics() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        profileRepository.save(new Profile(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            "FL",
            null,
            null,
            null,
            null
        ));

        financeInfoRepository.save(new FinanceInfo(
            "single",
            null,
            null,
            null,
            null,
            null,
            100,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User user = new User("test", "test", authorities);
        SecurityContext ctx = SecurityContextHolder.createEmptyContext();
        ctx.setAuthentication(new UsernamePasswordAuthenticationToken(user, null, authorities));
        SecurityContextHolder.setContext(ctx);

        Map<String, Integer> stateFrequencies = new HashMap<>();
        Map<String, Integer> filingStatusFrequencies = new HashMap<>();
        Map<String, Integer> incomeFrequencies = new HashMap<>();

        stateFrequencies.put("FL", 1);
        filingStatusFrequencies.put("single", 1);
        incomeFrequencies.put("100-100", 0);

        Assertions.assertEquals(adminController.calculateAnalytics(), ResponseEntity.ok(new Analytics(stateFrequencies, filingStatusFrequencies, incomeFrequencies)));

        SecurityContextHolder.clearContext();
    }

}
