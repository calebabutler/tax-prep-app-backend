package com.skillstorm.taxprepapp;

import java.security.Principal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.skillstorm.taxprepapp.controllers.FinanceInfoController;
import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.repositories.FinanceInfoRepository;
import com.skillstorm.taxprepapp.repositories.ProfileRepository;

@SpringBootTest
public class FinanceInfoControllerTests {
    
	@Autowired
	FinanceInfoController financeInfoController;

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
    public void testGetInfo() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testGetInfo");
        ResponseEntity<FinanceInfo> info = financeInfoController.getInfo(principal);
        Assertions.assertEquals(info, ResponseEntity.badRequest().build());
    }

    @Test
    public void testCreateInfo() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();
        
        Principal principal = new ExamplePrincipal("testCreateInfo");
        FinanceInfo info = new FinanceInfo(
            "Single",
            null,
            null,
            null,
            null,
            null,
            5000000,
            0,
            0,
            0,
            0,
            0,
            null
        );
        ResponseEntity<Void> response = financeInfoController.createInfo(principal, info);
        Assertions.assertEquals(response, ResponseEntity.ok().build());

        ResponseEntity<FinanceInfo> returnFinanceInfo = financeInfoController.getInfo(principal);
        info.setId(null);
        info.setOauthId(null);
        Assertions.assertEquals(returnFinanceInfo, ResponseEntity.ok(info));

        FinanceInfo changeInfo = new FinanceInfo(
            null,
            "Mary",
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

        ResponseEntity<Void> changeResponse = financeInfoController.updateInfo(principal, changeInfo);
        Assertions.assertEquals(changeResponse, ResponseEntity.ok().build());
    }

    @Test
    public void testBadCreateInfo() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testBadCreateInfo");

        FinanceInfo changeInfo = new FinanceInfo(
            null,
            "Mary",
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

        ResponseEntity<Void> badChangeResponse = financeInfoController.updateInfo(principal, changeInfo);
        Assertions.assertEquals(badChangeResponse, ResponseEntity.badRequest().build());

        FinanceInfo badInfo = new FinanceInfo(
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
            null,
            null
        );

        ResponseEntity<Void> badResponse = financeInfoController.createInfo(principal, badInfo);
        Assertions.assertEquals(badResponse, ResponseEntity.badRequest().build());
    }

}
