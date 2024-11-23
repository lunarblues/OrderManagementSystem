package com.ordermanagementsystem.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO implements Serializable {

    private int userId;

    @NotNull
    @Size(min = 5)
    private String username;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    private String email;

}
