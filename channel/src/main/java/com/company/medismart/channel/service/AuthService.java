package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.Login;

public interface AuthService {
    String login(Login login);
    Boolean logout(String username);
}
