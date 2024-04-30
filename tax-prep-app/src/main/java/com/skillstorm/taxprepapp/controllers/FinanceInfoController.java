package com.skillstorm.taxprepapp.controllers;

import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.services.FinanceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/finances")
@CrossOrigin
public class FinanceInfoController {

    @Autowired
    FinanceInfoService financeInfoService;

    @GetMapping
    public ResponseEntity<FinanceInfo> getInfo(Principal principal) {
        String oauthId = principal.getName();
        Optional<FinanceInfo> info = financeInfoService.getInfo(oauthId);
        if (info.isPresent()) {
            return ResponseEntity.ok(info.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Void> createInfo(Principal principal, @RequestBody FinanceInfo info) {
        String oauthId = principal.getName();
        boolean successful = financeInfoService.createInfo(oauthId, info);
        if (successful) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateInfo(Principal principal, @RequestBody FinanceInfo info) {
        String oauthId = principal.getName();
        boolean successful = financeInfoService.updateInfo(oauthId, info);
        if (successful) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
