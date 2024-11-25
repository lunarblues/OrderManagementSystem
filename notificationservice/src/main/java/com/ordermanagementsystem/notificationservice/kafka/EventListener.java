package com.ordermanagementsystem.notificationservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordermanagementsystem.event.OrderEvent;
import com.ordermanagementsystem.event.UserCreationReqEvent;
import com.ordermanagementsystem.notificationservice.service.MailService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventListener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final MailService mailService;

    @Autowired
    public EventListener(MailService mailService) {
        this.mailService = mailService;
    }

    @KafkaListener(topics = "UserCreationReq", groupId = "notification-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeUserCreationReq(ConsumerRecord<String, String> record) {
        try {
            UserCreationReqEvent event = objectMapper.readValue(record.value(), UserCreationReqEvent.class);
            mailService.sendEmail(event.getMail(), "user verification code", event.getOTP());
        } catch (Exception e) {
            System.err.println("Error processing UserCreationReqEvent: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "OrderPlaced", groupId = "notification-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeOrderPlacedEvent(ConsumerRecord<String, String> record) {
        try {
            OrderEvent event = objectMapper.readValue(record.value(), OrderEvent.class);
            mailService.sendEmail(event.getMail(), "Order status", "Order was placed successfully!");
        } catch (Exception e) {
            System.err.println("Error processing OrderPlacedEvent: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "OrderCompleted", groupId = "notification-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeOrderCompletedEvent(ConsumerRecord<String, String> record) {
        try {
            OrderEvent event = objectMapper.readValue(record.value(), OrderEvent.class);
            mailService.sendEmail(event.getMail(), "Order status", "Order was placed successfully!");
        } catch (Exception e) {
            System.err.println("Error processing OrderPlacedEvent: " + e.getMessage());
        }
    }
}
