package com.ordermanagementsystem.userservice.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.flakeidgen.FlakeIdGenerator;
import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicates;
import com.ordermanagementsystem.dto.UserDTO;
import com.ordermanagementsystem.userservice.otp.UserWithOtp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class UserOtpRepository {

    private static final String MAP_NAME = "user_otp_data";
    private static final String ID_GENERATOR_NAME = "otpIdGenerator";

    private final HazelcastInstance hazelcastInstance;

    @Autowired
    public UserOtpRepository(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    private String generateUniqueKey() {
        FlakeIdGenerator idGenerator = hazelcastInstance.getFlakeIdGenerator(ID_GENERATOR_NAME);
        return String.valueOf(idGenerator.newId());
    }

    public void saveUserWithOtp(String otp, UserDTO userDTO) {
        IMap<String, UserWithOtp> userMap = hazelcastInstance.getMap(MAP_NAME);
        userMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        String uniqueKey = generateUniqueKey();
        UserWithOtp userWithOtp = new UserWithOtp(otp, userDTO);
        userMap.put(uniqueKey, userWithOtp, 24, TimeUnit.HOURS);
    }



    //TODO change runtimeexception with custom VerificationCodeNotFoundException
    public UserWithOtp getUserByOtp(String otp) {
        IMap<String, UserWithOtp> userMap = hazelcastInstance.getMap(MAP_NAME);
        return userMap.values(Predicates.equal("otp", otp)).stream().findFirst().orElseThrow(RuntimeException::new);
    }

}

