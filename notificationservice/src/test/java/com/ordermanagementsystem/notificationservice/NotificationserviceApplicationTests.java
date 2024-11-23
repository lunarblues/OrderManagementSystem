package com.ordermanagementsystem.notificationservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@SpringBootTest
@EnableAutoConfiguration(exclude = { KafkaAutoConfiguration.class })
class NotificationserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Configuration
	static class MockKafkaConfig {
		@Bean
		public Object mockKafkaBeans() {
			return mock(Object.class);
		}
	}
}
