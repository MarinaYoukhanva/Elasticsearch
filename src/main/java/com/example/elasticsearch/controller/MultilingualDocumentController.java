package com.example.elasticsearch.controller;

import com.example.elasticsearch.dto.DocumentCreateDTO;
import com.example.elasticsearch.dto.DocumentResponseDTO;
import com.example.elasticsearch.service.MultilingualDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/documents")
@RequiredArgsConstructor
public class MultilingualDocumentController {

    private final MultilingualDocumentService multilingualDocumentService;

    @PostMapping("/save")
    public ResponseEntity<DocumentResponseDTO> saveMultilingualDocument(
            @RequestBody DocumentCreateDTO createDTO
            ){
        return ResponseEntity.ok(
                multilingualDocumentService.save(createDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DocumentResponseDTO>> getAllMultilingualDocuments() {
        return ResponseEntity.ok(
                multilingualDocumentService.findAll()
        );
    }

    @GetMapping("/search-in-specific-language")
    public ResponseEntity<List<DocumentResponseDTO>> searchInSpecificLanguage(
            @RequestParam String langCode,
            @RequestParam String text
    ){
        return ResponseEntity.ok(
                multilingualDocumentService.searchInSpecificLanguage(langCode, text)
        );
    }

    @GetMapping("/search-in-all-languages")
    public ResponseEntity<List<DocumentResponseDTO>> searchInAllLanguages(
            @RequestParam String text
    ){
        return ResponseEntity.ok(
                multilingualDocumentService.searchInAllLanguages(text)
        );
    }
}
