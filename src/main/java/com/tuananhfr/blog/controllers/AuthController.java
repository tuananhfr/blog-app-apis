package com.tuananhfr.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuananhfr.blog.exceptions.ApiException;
import com.tuananhfr.blog.payloads.JwtAuthRequest;
import com.tuananhfr.blog.payloads.JwtAuthResponse;
import com.tuananhfr.blog.payloads.UserDto;
import com.tuananhfr.blog.security.JwtTokenHelper;
import com.tuananhfr.blog.services.UserService;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody JwtAuthRequest request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);
        
        JwtAuthResponse response = JwtAuthResponse.builder()
                .token(token).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    private void doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
        	authenticationManager.authenticate(authentication);


        } catch (BadCredentialsException e) {
        	
            throw new ApiException("Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
    
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {

        UserDto registerUser = this.userService.registerNewUser(userDto);
        return new ResponseEntity<UserDto>(registerUser, HttpStatus.CREATED);
    }
}
