package ru.dev.K8sCacheApp.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.dev.K8sCacheApp.dto.*;

@Service
public class OrderService {

    @Cacheable(value = "orders", key = "#orderId")
    public OrderResponse getOrder(String orderId) {
        // Имитация долгой работы
        simulateHeavyWork();

        // 1. Строим вложенный адрес
        Address address = new Address("St Petersburg", "Nevsky Prospect", "190000");

        // 2. Строим детали клиента
        CustomerDetails customer = new CustomerDetails("Ivan", "Kudryashov", "kudryash@dev.ru", address);

        // 3. Строим список позиций заказа
        List<OrderItem> items = List.of(
                new OrderItem("item-1", "Laptop K8s-Pro", 1, 120000.00),
                new OrderItem("item-2", "Wireless Mouse", 2, 2500.50)
        );

        // 4. Собираем теги и метаданные
        Set<String> tags = Set.of("electronic", "express-delivery", "premium-client");
        Map<String, Object> metadata = Map.of(
                "ipAddress", "192.168.1.50",
                "userAgent", "PostmanRuntime/7.43.0",
                "retryCount", 0
        );

        // 5. Возвращаем комплексный объект
        return new OrderResponse(
                orderId,
                123L,
                125001.00,
                new BigDecimal("25000.20"),
                Currency.RUB,
                OrderStatus.CONFIRMED,
                true,
                Boolean.TRUE,
                Instant.now(), // Проверка сериализации Java 8+ временных типов
                customer,
                items,
                tags,
                metadata
        );
    }

    private void simulateHeavyWork() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
