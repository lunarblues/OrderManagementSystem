package com.ordermanagementsystem.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordermanagementsystem.dto.UserDTO;
import com.ordermanagementsystem.event.UserCreationReqEvent;
import com.ordermanagementsystem.event.UserVerifiedEvent;
import com.ordermanagementsystem.userservice.converters.UserDTOConverter;
import com.ordermanagementsystem.dto.PasswordChangeDTO;
import com.ordermanagementsystem.userservice.exceptions.UserNotFoundException;
import com.ordermanagementsystem.userservice.hazelcast.UserOtpRepository;
import com.ordermanagementsystem.userservice.kafka.EventProducer;
import com.ordermanagementsystem.userservice.model.User;
import com.ordermanagementsystem.userservice.otp.OTPGenerator;
import com.ordermanagementsystem.userservice.repository.RoleRepository;
import com.ordermanagementsystem.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final EventProducer eventProducer;
    private final ObjectMapper objectMapper;
    private final UserOtpRepository userOtpRepository;
    private final RoleRepository roleRepository;

    public void addUser(final UserDTO userDTO) {
        String otp = OTPGenerator.generateOTP();
        userOtpRepository.saveUserWithOtp(otp, userDTO);
        UserCreationReqEvent event = new UserCreationReqEvent(otp, userDTO.getEmail());
        try {
            String message = objectMapper.writeValueAsString(event);
            eventProducer.sendEvent("UserCreationReq", null, message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing event: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error sending event to Kafka: " + e.getMessage(), e);
        }
    }

    public void verifyUser(String otp) {
        System.out.println("starting inspection");
        UserDTO userDTO = userOtpRepository.getUserByOtp(otp).getUserDTO();
        User user = UserDTOConverter.fromDTO(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(roleRepository.findById(2L).get());
        userRepository.save(user);
        UserVerifiedEvent event = new UserVerifiedEvent(user.getEmail());
        try {
            String message = objectMapper.writeValueAsString(event);
            eventProducer.sendEvent("UserCreationReq", null, message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing event: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error sending event to Kafka: " + e.getMessage(), e);
        }
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void changePassword(final PasswordChangeDTO passwordChangeDTO) {
        Authentication userDetails = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(userDetails.getName()).get();
        user.setPassword(passwordEncoder.encode(passwordChangeDTO.getPassword()));
        userRepository.save(user);
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .peek(user -> user.setPassword(""))
                .map(user -> UserDTOConverter.toDTO(user))
                .collect(Collectors.toList());
    }

    public UserDTO getUser(long id) {
        UserDTO userDTO = UserDTOConverter.toDTO(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
        userDTO.setPassword("");
        return userDTO;
    }

}
