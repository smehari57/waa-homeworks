package com.starproject.waa.homeworks.controller.controllerSec;


import com.starproject.waa.homeworks.domain.dto.request.LoginRequest;
import com.starproject.waa.homeworks.domain.dto.request.RefreshTokenRequest;
import com.starproject.waa.homeworks.domain.dto.response.LoginResponse;
import com.starproject.waa.homeworks.service.serviceSec.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authService) {
        this.authenticationService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authenticationService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authenticationService.refreshToken(refreshTokenRequest);
    }

}
