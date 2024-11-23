package com.ordermanagementsystem.userservice.controller;

import com.ordermanagementsystem.dto.AuthRequestDTO;
import com.ordermanagementsystem.dto.AuthResponseDTO;
import com.ordermanagementsystem.userservice.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authService;

    @PostMapping("/api/login")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody @Valid final AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(authService.authenticate(authRequestDTO));
    }

}
