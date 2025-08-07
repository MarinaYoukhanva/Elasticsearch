package com.example.elasticsearch.dto;

import java.util.Map;

public record DocumentCreateDTO(
        String identifier,
        Map<String, String> body
) {
}
