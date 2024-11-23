package com.ordermanagementsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    @NotNull
    @Size(min = 5)
    private String product;

    @Min(value = 1)
    private int quantity;

    private long userId;
}
