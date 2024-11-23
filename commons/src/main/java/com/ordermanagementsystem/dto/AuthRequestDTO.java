package com.ordermanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequestDTO {
    @NotNull
    @Size(min = 5)
    private String username;

    @NotNull
    @Size(min = 8)
    private String password;
}
