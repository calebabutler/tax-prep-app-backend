package com.skillstorm.taxprepapp.controllers;

import com.skillstorm.taxprepapp.TaxCalculator;
import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.services.FinanceInfoService;
import com.skillstorm.taxprepapp.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController("/tax")
public class TaxController {

    @Autowired
    ProfileService profileService;

    @Autowired
    FinanceInfoService financeInfoService;

    @GetMapping("/calculate")
    public ResponseEntity<Long> calculateTaxes(Principal principal) {
        String oauthId = principal.getName();
        Optional<Profile> profile = profileService.getProfile(oauthId);
        Optional<FinanceInfo> info = financeInfoService.getInfo(oauthId);
        if (profile.isPresent() && info.isPresent()) {
            long tax = TaxCalculator.calculateTaxes(profile.get(), info.get());
            return ResponseEntity.ok(tax);
        }
        return ResponseEntity.badRequest().build();
    }

}
