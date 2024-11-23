package com.ordermanagementsystem.userservice;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

//@TestConfiguration
//public class EmbeddedHazelcastConfig {
//
//    @Bean
//    public HazelcastInstance hazelcastInstance() {
//        Config config = new Config();
//        config.setClusterName("test-cluster");
//        return Hazelcast.newHazelcastInstance(config);
//    }
//
//}

