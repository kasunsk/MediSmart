package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.dto.Login;
import com.company.medismart.channel.dto.LoginResponse;
import com.company.medismart.channel.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public LoginResponse login(Login login) {
        LoginResponse response = new LoginResponse();
        response.setAuthToken("abcd");
        response.setSuccess(true);
        response.setUsername("kasun");
        return response;
    }

    @Override
    public LoginResponse logout(String username) {
        LoginResponse response = new LoginResponse();
        response.setSuccess(true);
        return response;
    }
}
