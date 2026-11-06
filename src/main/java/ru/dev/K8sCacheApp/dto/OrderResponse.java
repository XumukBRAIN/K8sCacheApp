package ru.dev.K8sCacheApp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 1. Главный рекорд ответа
public record OrderResponse(
        String orderId,                             // String
        Long clientId,                              // Обертка (обработка null)
        double amount,                              // Примитив с плавающей точкой
        BigDecimal tax,                             // Точные финансовые вычисления
        Currency currency,                          // Перечисление (Enum)
        OrderStatus status,                         // Перечисление (Enum)
        boolean isUrgent,                           // Булев тип примитив
        Boolean isPaid,                             // Булев тип обертка
        Instant createdAt,                          // Современная дата/время (JSR-310)
        CustomerDetails customerDetails,            // Вложенный объект (Record)
        List<OrderItem> items,                      // Список вложенных объектов (List)
        Set<String> DynamicTags,                    // Коллекция уникальных строк (Set)
        Map<String, Object> metadata                // Динамическая карта (Map)
) {}
