package com.example.db_authentication.controller;

import com.example.db_authentication.dto.UserRegisterRequestDto;
import com.example.db_authentication.dto.UserRegisterResponseDto;
import com.example.db_authentication.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/register")
    ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto userRegisterRequestDto){
        UserRegisterResponseDto userRegisterResponseDto = authService.register(userRegisterRequestDto);
    return ResponseEntity.ok(userRegisterResponseDto);
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
