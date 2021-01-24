package com.company.medismart.channel.controller;

import com.company.medismart.channel.dto.Login;
import com.company.medismart.channel.dto.LoginResponse;
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
    public LoginResponse login(@RequestBody Login login) {
        log.info("Login Request received for {}", login.toString());
        return authService.login(login);
    }

    @CrossOrigin
    @PostMapping(value = "/logout")
    public LoginResponse logout() {
        String username = "kasun";
        log.info("Logout Request received for {}", username);
        return authService.logout(username);
    }

    @CrossOrigin
    @PostMapping(value = "/isLoggedIn")
    public LoginResponse isLoggedIn() {
        LoginResponse response = new LoginResponse();
        response.setSuccess(false);
        return response;
    }
}
