package com.example.elasticsearch.service;

import com.example.elasticsearch.dto.DocumentCreateDTO;
import com.example.elasticsearch.dto.DocumentResponseDTO;

import java.util.List;

public interface MultilingualDocumentService {

    DocumentResponseDTO save(DocumentCreateDTO createDTO);

    List<DocumentResponseDTO> findAll();

    List<DocumentResponseDTO> searchInSpecificLanguage(
            String langCode, String text);

    List<DocumentResponseDTO> searchInAllLanguages(
            String text);
}
