package ru.dev.K8sCacheApp.dto;

public record Address(
        String city,
        String street,
        String zipCode
) {}