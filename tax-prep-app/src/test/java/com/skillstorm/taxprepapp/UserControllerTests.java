package com.skillstorm.taxprepapp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import java.security.Principal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.servlet.view.RedirectView;

import com.skillstorm.taxprepapp.controllers.UserController;

@SpringBootTest
class UserControllerTests {

	@Autowired
	UserController userController;

	@Test
	void testHelloWorld() {
		String output = userController.helloWorld();
		Assertions.assertEquals("hello world", output);
	}

	@Test
	void testUserInfo() {
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("sub", "123456789");
		attributes.put("name", "Mary Smith");
		attributes.put("email", "mary.smith@bmail.com");
		attributes.put("picture", "bmail.com/mary");

		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");

		OAuth2User user = new DefaultOAuth2User(authorities, attributes, "sub");
		Map<String, Object> infoAttributes = userController.userInfo(user);
		Assertions.assertEquals(attributes, infoAttributes);
	}

	@Test
	void testAccessToken() {
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("sub", "123456789");
		attributes.put("name", "Mary Smith");
		attributes.put("email", "mary.smith@bmail.com");
		attributes.put("picture", "bmail.com/mary");

		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");

		OAuth2User user = new DefaultOAuth2User(authorities, attributes, "sub");

		OAuth2AuthenticationToken token = new OAuth2AuthenticationToken(user, authorities, "google");

		Assertions.assertThrows(NullPointerException.class, () -> userController.accessToken(token));
		String emptyString = userController.accessToken(null);
		Assertions.assertEquals(emptyString, "");
	}

	private class ExamplePrincipal implements Principal {

		@Override
		public String getName() {
			return "test";
		}

	}

	@Test
	void testGetOAuth2Id() {
		Principal principal = new ExamplePrincipal();
		String test = userController.getOAuthId(principal);
		Assertions.assertEquals(test, "test");
	}

	@Test
	void testLogoutSuccess() {
		RedirectView view = userController.redirectLogoutView();
		Assertions.assertEquals(view.toString(), (new RedirectView(TaxPrepAppApplication.getFrontendUrl())).toString());
	}

	@Test
	void testSignin() {
		RedirectView view = userController.redirectView();
		Assertions.assertEquals(view.toString(), (new RedirectView(TaxPrepAppApplication.getFrontendUrl())).toString());
	}

}
