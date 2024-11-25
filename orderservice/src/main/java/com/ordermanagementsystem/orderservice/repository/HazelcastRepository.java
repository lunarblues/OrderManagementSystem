package com.ordermanagementsystem.orderservice.repository;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.flakeidgen.FlakeIdGenerator;
import com.hazelcast.map.IMap;
import com.ordermanagementsystem.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
public class HazelcastRepository {

    private final IMap<String, OrderDTO> orderMap;
    private final HazelcastInstance hazelcastInstance;

    @Autowired
    public HazelcastRepository(HazelcastInstance hazelcastInstance) {
        this.orderMap = hazelcastInstance.getMap("orders");
        this.hazelcastInstance = hazelcastInstance;
    }

    private String generateUniqueKey() {
        FlakeIdGenerator idGenerator = hazelcastInstance.getFlakeIdGenerator("ID_GENERATOR_ORDERS");
        return String.valueOf(idGenerator.newId());
    }

    public void saveOrder(OrderDTO order) {
        orderMap.put(generateUniqueKey(), order,24, TimeUnit.HOURS);
    }

    public List<OrderDTO> findByUserId(long userId) {
        return orderMap.values()
                .stream()
                .filter(order -> order.getUserId() == userId)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> findAll() {
        return orderMap.values().stream().toList();
    }

    public boolean removeOrder(long orderId) {
        String keyToRemove = orderMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getOrderId() == orderId)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse(null);

        if (keyToRemove != null) {
            orderMap.remove(keyToRemove);
            return true; // Removal was successful
        }
        return false; // No matching order found
    }
}

