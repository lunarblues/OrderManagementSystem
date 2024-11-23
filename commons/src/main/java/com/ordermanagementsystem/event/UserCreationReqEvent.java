package com.ordermanagementsystem.event;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreationReqEvent {

    private String OTP;

    private String mail;

}
