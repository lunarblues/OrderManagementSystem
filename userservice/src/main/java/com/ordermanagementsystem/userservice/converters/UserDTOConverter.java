package com.ordermanagementsystem.userservice.converters;

import com.ordermanagementsystem.userservice.model.User;
import com.ordermanagementsystem.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId() != null ? user.getId().intValue() : 0); // Convert Long to int safely
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

    public static User fromDTO(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        // Do not set the ID here as per the requirement.
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());

        return user;
    }
}
