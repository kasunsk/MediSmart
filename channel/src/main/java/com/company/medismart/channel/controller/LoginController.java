package com.company.medismart.channel.controller;

import com.company.medismart.channel.dto.Login;
import com.company.medismart.channel.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthService authService;

    @CrossOrigin
    @PostMapping(value = "/login")
    public String login(@RequestBody Login login) {
        log.info("Login Request received for {}", login.toString());
        return authService.login(login);
    }

    @CrossOrigin
    @PostMapping(value = "/logout")
    public Boolean logout(@PathVariable("username") String username) {
        log.info("Logout Request received for {}", username);
        return authService.logout(username);
    }
}
