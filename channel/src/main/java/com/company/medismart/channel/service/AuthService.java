package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.Login;
import com.company.medismart.channel.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(Login login);
    LoginResponse logout(String username);
}
