package ru.dev.K8sCacheApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.dev.K8sCacheApp.dto.OrderResponse;
import ru.dev.K8sCacheApp.service.OrderService;

import java.time.LocalDateTime;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/{orderId}")
    public OrderResponse getOrder(@PathVariable String orderId) {
        try {
            System.out.println("Запрос пришел, время: " + LocalDateTime.now());
            return orderService.getOrder(orderId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get order", e);
        } finally {
            System.out.println("Запрос отработал, время: " + LocalDateTime.now());
        }
    }
}
