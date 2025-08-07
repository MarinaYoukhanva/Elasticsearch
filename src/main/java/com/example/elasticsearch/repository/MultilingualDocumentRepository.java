package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.MultilingualDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultilingualDocumentRepository
        extends ElasticsearchRepository<MultilingualDocument, String> {

    @Query("{ \"wildcard\": { \"body.?0\": { \"value\": \"*?1*\" } } }")
    List<MultilingualDocument> findByLanguageAndTextContains(String langCode, String text);

    @Query("{\"query_string\": {\"query\": \"*?0*\", \"fields\": [\"body.*\"]}}")
    List<MultilingualDocument> findByTextContains(String text);
}
