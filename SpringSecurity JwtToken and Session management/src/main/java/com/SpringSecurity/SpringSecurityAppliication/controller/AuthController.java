package com.SpringSecurity.SpringSecurityAppliication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.SpringSecurityAppliication.dto.LoginDto;
import com.SpringSecurity.SpringSecurityAppliication.dto.SignupDto;
import com.SpringSecurity.SpringSecurityAppliication.dto.UserDto;
import com.SpringSecurity.SpringSecurityAppliication.services.AuthService;
import com.SpringSecurity.SpringSecurityAppliication.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
     private final UserService userService;
     private final AuthService authService;

     @PostMapping(path="/signup")
          public ResponseEntity<UserDto> signup(@RequestBody SignupDto signupDto){
            UserDto userDto = userService.signup(signupDto);
            return ResponseEntity.ok(userDto);
          }


          @PostMapping(path = "/login")
          public ResponseEntity<String> login(@RequestBody LoginDto loginDto  , HttpServletRequest request , HttpServletResponse response){
            String token=authService.login(loginDto);
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);

            return ResponseEntity.ok(token);
          }
}
