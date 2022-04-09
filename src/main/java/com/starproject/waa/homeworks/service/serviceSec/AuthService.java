package com.starproject.waa.homeworks.service.serviceSec;


import com.starproject.waa.homeworks.domain.dto.request.LoginRequest;
import com.starproject.waa.homeworks.domain.dto.request.RefreshTokenRequest;
import com.starproject.waa.homeworks.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
