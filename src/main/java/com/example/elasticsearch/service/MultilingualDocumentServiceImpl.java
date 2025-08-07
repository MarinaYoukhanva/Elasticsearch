package com.example.elasticsearch.service;

import com.example.elasticsearch.dto.DocumentCreateDTO;
import com.example.elasticsearch.dto.DocumentMapper;
import com.example.elasticsearch.dto.DocumentResponseDTO;
import com.example.elasticsearch.entity.MultilingualDocument;
import com.example.elasticsearch.repository.MultilingualDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MultilingualDocumentServiceImpl implements MultilingualDocumentService {

    private final MultilingualDocumentRepository multilingualDocumentRepository;

    @Transactional
    @Override
    public DocumentResponseDTO save(DocumentCreateDTO createDTO) {
        return DocumentMapper.toDto(
                multilingualDocumentRepository.save(
                        DocumentMapper.toEntity(createDTO)
                )
        );
    }

    @Override
    public List<DocumentResponseDTO> findAll() {
        Iterable<MultilingualDocument> iterableDocuments = multilingualDocumentRepository.findAll();
        List<DocumentResponseDTO> response = new ArrayList<>();

        for (MultilingualDocument doc : iterableDocuments) {
            response.add(DocumentMapper.toDto(doc));
        }
        return response;
    }

    @Override
    public List<DocumentResponseDTO> searchInSpecificLanguage(
            String langCode, String text) {
        return multilingualDocumentRepository.findByLanguageAndTextContains(
                        langCode, text
                )
                .stream().map(
                        DocumentMapper::toDto
                ).toList();
    }

    @Override
    public List<DocumentResponseDTO> searchInAllLanguages(
            String text) {
        return multilingualDocumentRepository.findByTextContains(
                        text
                )
                .stream().map(
                        DocumentMapper::toDto
                ).toList();
    }
}
