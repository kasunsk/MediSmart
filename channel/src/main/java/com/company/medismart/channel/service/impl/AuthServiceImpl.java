package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.dto.Login;
import com.company.medismart.channel.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String login(Login login) {
        return "abcdefgh";
    }

    @Override
    public Boolean logout(String username) {
        return true;
    }
}
