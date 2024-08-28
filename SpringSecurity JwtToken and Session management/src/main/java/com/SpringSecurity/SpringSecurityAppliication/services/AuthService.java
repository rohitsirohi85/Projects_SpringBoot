package com.SpringSecurity.SpringSecurityAppliication.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.SpringSecurity.SpringSecurityAppliication.Entity.User;
import com.SpringSecurity.SpringSecurityAppliication.dto.LoginDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final AuthenticationManager authenticationManager;  // only used for authentication
     private final JwtService jwtService;
private final SessionService sessionService;

     public String login(LoginDto loginDto) {
         Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

  // it will create and return token if login success

      User user = (User) authentication.getPrincipal();
      String token = jwtService.createTokens(user);
      sessionService.generateSession(user , token);
      return token;
    }

}
