package com.ordermanagementsystem.userservice.service;

import com.ordermanagementsystem.dto.AuthRequestDTO;
import com.ordermanagementsystem.dto.AuthResponseDTO;
import com.ordermanagementsystem.userservice.model.User;
import com.ordermanagementsystem.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthResponseDTO authenticate(AuthRequestDTO authRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
        );
        User user = (User)userDetailsService.loadUserByUsername(authRequestDTO.getUsername());
        return new AuthResponseDTO(JwtUtil.createToken(authRequestDTO.getUsername(), user.getId(), user.getRole().getName(), user.getEmail(),1440*60*1000));
    }
}
