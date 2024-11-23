package com.ordermanagementsystem.userservice.hazelcast;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.client.HazelcastClient;
import com.ordermanagementsystem.userservice.otp.CustomPortableFactory;
import com.ordermanagementsystem.userservice.otp.UserWithOtp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastClientConfig {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("hazelcast:5701");
        clientConfig.setClusterName("dev");
        clientConfig.getSerializationConfig()
                .addPortableFactory(UserWithOtp.FACTORY_ID, new CustomPortableFactory());
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}
