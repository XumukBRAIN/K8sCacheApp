package ru.dev.K8sCacheApp.dto;

public record OrderItem(
        String itemId,
        String name,
        int quantity,                               // Целочисленный примитив
        double price
) {}