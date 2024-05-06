package com.skillstorm.taxprepapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.skillstorm.taxprepapp.repositories.AdminRepository;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Autowired
    AdminRepository adminRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) ->
            authorizeHttpRequests
                .requestMatchers("/logout_success").permitAll()
                .anyRequest().authenticated()
                )
                .logout(logout -> logout.deleteCookies("JSESSIONID").invalidateHttpSession(true)
                        .logoutUrl("/logout").logoutSuccessUrl("/logout_success"));
        
        http.csrf(csrf -> csrf.disable());

        http.cors(cors -> {
            cors.configurationSource(request -> {
                CorsConfiguration corsConfig = new CorsConfiguration();

                corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:5173")); 
                corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));  
                corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));   
                corsConfig.setAllowCredentials(true);                               
                corsConfig.setMaxAge(3600L); 

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", corsConfig);
                return corsConfig;
            });
        });
        http.oauth2Login(
            oauth2 -> oauth2.userInfoEndpoint(
                userInfo -> userInfo.oidcUserService(this.oidcUserService())));

        return http.build();
    }

    private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
        final OidcUserService delegate = new OidcUserService();
        return (userRequest) -> {
            OidcUser oidcUser = delegate.loadUser(userRequest);
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            if (adminRepository.findById(oidcUser.getSubject()).isPresent()) {
                mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            oidcUser = new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
            return oidcUser;
        };
    }

}
