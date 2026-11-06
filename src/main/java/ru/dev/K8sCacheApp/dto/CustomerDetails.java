package ru.dev.K8sCacheApp.dto;

public record CustomerDetails(
        String firstName,
        String lastName,
        String email,
        Address address                             // Глубокая вложенность
) {}