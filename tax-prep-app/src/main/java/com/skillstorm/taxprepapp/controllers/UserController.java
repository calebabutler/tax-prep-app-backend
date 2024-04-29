package com.skillstorm.taxprepapp.controllers;


import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class UserController {

    @Autowired
    private OAuth2AuthorizedClientService clientService;

    @GetMapping("/helloWorld")
    @ResponseBody
    public String helloWorld() {
        return "hello world";
    }
    
    @GetMapping("/userInfo")
    @ResponseBody
    public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }
    
    @GetMapping("/accessToken")
    @ResponseBody
    public String accessToken(Authentication auth){
        if (auth instanceof OAuth2AuthenticationToken){
            OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken)auth;
            OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(), authToken.getName());
            return client.getAccessToken().getTokenValue();
        }
        return "";
    }

    @GetMapping("/oauthId")
    @ResponseBody
    public String getOAuthId(Principal principal){
        return principal.getName();
    }

    @GetMapping("/signin")
    public RedirectView redirectView(){
        return new RedirectView("http://localhost:5173");
    }
}

