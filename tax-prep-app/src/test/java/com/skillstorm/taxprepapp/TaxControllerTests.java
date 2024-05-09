package com.skillstorm.taxprepapp;

import java.security.Principal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.skillstorm.taxprepapp.controllers.FinanceInfoController;
import com.skillstorm.taxprepapp.controllers.ProfileController;
import com.skillstorm.taxprepapp.controllers.TaxController;
import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.repositories.FinanceInfoRepository;
import com.skillstorm.taxprepapp.repositories.ProfileRepository;

@SpringBootTest
public class TaxControllerTests {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    FinanceInfoRepository financeInfoRepository;

    @Autowired
    TaxController taxController;

    @Autowired
    ProfileController profileController;

    @Autowired
    FinanceInfoController financeInfoController;

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
    public void testBadCalculateTaxes() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testBadCalculateTaxes");
        ResponseEntity<Long> response = taxController.calculateTaxes(principal);
        Assertions.assertEquals(response, ResponseEntity.badRequest().build());
    }

    @Test
    public void testBadCalculateTaxes2() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testBadCalculateTaxes2");

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
        profileController.createProfile(principal, profile);

        ResponseEntity<Long> response = taxController.calculateTaxes(principal);
        Assertions.assertEquals(response, ResponseEntity.badRequest().build());
    }

    @Test
    public void testCalculateTaxesSingle() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testBadCalculateTaxes");

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

        FinanceInfo info = new FinanceInfo(
            "Single",
            null,
            null,
            null,
            null,
            null,
            100000000,
            2000,
            2000,
            2000,
            2000,
            2000,
            null
        );

        profileController.createProfile(principal, profile);
        financeInfoController.createInfo(principal, info);

        ResponseEntity<Long> response = taxController.calculateTaxes(principal);
        Assertions.assertEquals(response, ResponseEntity.ok((long) 32513490));
    }

    @Test
    public void testCalculateTaxesJointly() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testBadCalculateTaxes");

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

        FinanceInfo info = new FinanceInfo(
            "Married Filing Jointly",
            null,
            null,
            null,
            null,
            null,
            100000000,
            2000,
            2000,
            2000,
            2000,
            2000,
            null
        );

        profileController.createProfile(principal, profile);
        financeInfoController.createInfo(principal, info);

        ResponseEntity<Long> response = taxController.calculateTaxes(principal);
        Assertions.assertEquals(response, ResponseEntity.ok((long) 28959240));
    }

    @Test
    public void testCalculateTaxesSeparately() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testBadCalculateTaxes");

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

        FinanceInfo info = new FinanceInfo(
            "Married Filing Separately",
            null,
            null,
            null,
            null,
            null,
            100000000,
            2000,
            2000,
            2000,
            2000,
            2000,
            null
        );

        profileController.createProfile(principal, profile);
        financeInfoController.createInfo(principal, info);

        ResponseEntity<Long> response = taxController.calculateTaxes(principal);
        Assertions.assertEquals(response, ResponseEntity.ok((long) 32463540));
    }

    @Test
    public void testCalculateTaxesUnknown() {
        profileRepository.deleteAll();
        financeInfoRepository.deleteAll();

        Principal principal = new ExamplePrincipal("testBadCalculateTaxes");

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

        FinanceInfo info = new FinanceInfo(
            "Unknown",
            null,
            null,
            null,
            null,
            null,
            100000000,
            2000,
            2000,
            2000,
            2000,
            2000,
            null
        );

        profileController.createProfile(principal, profile);
        financeInfoController.createInfo(principal, info);

        ResponseEntity<Long> response = taxController.calculateTaxes(principal);
        Assertions.assertEquals(response, ResponseEntity.ok((long) 32513490));
    }

}
