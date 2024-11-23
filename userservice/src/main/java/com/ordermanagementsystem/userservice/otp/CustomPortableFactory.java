package com.ordermanagementsystem.userservice.otp;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;

public class CustomPortableFactory implements PortableFactory {

    @Override
    public Portable create(int classId) {
        if (classId == UserWithOtp.CLASS_ID) {
            return new UserWithOtp();
        }
        return null;
    }
}

