package com.SpringSecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

import com.SpringSecurityjwt.models.AuthenticationRequest;
import com.SpringSecurityjwt.models.AuthenticationResponse;
import com.SpringSecurityjwt.MyUserDetailsService;
import com.SpringSecurityjwt.util.JwtUtil;

 

@RestController
class HelloWorldController {

 

    @Autowired
    private AuthenticationManager authenticationManager;

 

    @Autowired
    private JwtUtil jwtTokenUtil;

 

    @Autowired
    private MyUserDetailsService userDetailsService;

 

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
            @ModelAttribute AuthenticationRequest authenticationRequest) throws Exception {

 

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

 

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

 

        final String jwt = jwtTokenUtil.generateToken(userDetails);

 

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

 

}
