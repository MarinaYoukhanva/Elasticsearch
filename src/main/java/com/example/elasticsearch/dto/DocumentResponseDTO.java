package com.example.elasticsearch.dto;

import java.util.Map;

public record DocumentResponseDTO(
        String id,
        Map<String, String> body
) {
}
