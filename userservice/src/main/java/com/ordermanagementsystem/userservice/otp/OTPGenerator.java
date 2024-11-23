package com.ordermanagementsystem.userservice.otp;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

public class OTPGenerator {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int OTP_LENGTH = 6;

    public static String generateOTP() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(CHARACTERS.charAt(secureRandom.nextInt(CHARACTERS.length())));
        }
        return otp.toString();
    }

}
