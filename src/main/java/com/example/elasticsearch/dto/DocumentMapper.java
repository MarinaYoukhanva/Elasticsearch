package com.example.elasticsearch.dto;

import com.example.elasticsearch.entity.MultilingualDocument;

public class DocumentMapper {
    public static MultilingualDocument toEntity(DocumentCreateDTO dto) {
        MultilingualDocument doc = new MultilingualDocument();
        doc.setIdentifier(dto.identifier());
        doc.setBody(dto.body());
        return doc;
    }

    public static DocumentResponseDTO toDto(MultilingualDocument doc) {
        return new DocumentResponseDTO(
                doc.getIdentifier(),
                doc.getBody()
        );
    }
}
