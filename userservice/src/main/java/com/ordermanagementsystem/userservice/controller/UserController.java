package com.ordermanagementsystem.userservice.controller;

import com.ordermanagementsystem.dto.UserDTO;
import com.ordermanagementsystem.dto.PasswordChangeDTO;
import com.ordermanagementsystem.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<String> registerUser(@Valid @RequestBody final UserDTO userDTO) {
        log.debug("registerUser invoked with {}", userDTO);
        userService.addUser(userDTO);
        return ResponseEntity.ok("User verification request sent successfully");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/users/verify/{otp}")
    public ResponseEntity<String> verifyUser(@PathVariable String otp) {
        log.debug("verifyUser invoked with OTP: {}", otp);
        userService.verifyUser(otp);
        return ResponseEntity.ok("User verified successfully.");
    }

    @PutMapping("/users/password")
    public ResponseEntity<String> updatePassword(@RequestBody final PasswordChangeDTO passwordChangeDTO) {
        userService.changePassword(passwordChangeDTO);
        return ResponseEntity.ok("Password changed successfully");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Deleted successfully");
    }
}
