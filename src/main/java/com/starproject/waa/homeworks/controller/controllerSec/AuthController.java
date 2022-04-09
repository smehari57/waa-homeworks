package com.starproject.waa.homeworks.controller.controllerSec;


import com.starproject.waa.homeworks.domain.dto.request.LoginRequest;
import com.starproject.waa.homeworks.domain.dto.request.RefreshTokenRequest;
import com.starproject.waa.homeworks.domain.dto.response.LoginResponse;
import com.starproject.waa.homeworks.service.serviceSec.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
