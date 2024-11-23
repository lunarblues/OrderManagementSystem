package com.ordermanagementsystem.event;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVerifiedEvent {
    private String mail;

}
