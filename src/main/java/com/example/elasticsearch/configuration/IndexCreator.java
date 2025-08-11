package com.example.elasticsearch.configuration;

import com.example.elasticsearch.entity.MultilingualDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class IndexCreator implements ApplicationRunner {

    private final ElasticsearchOperations operations;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IndexOperations indexOps = operations.indexOps(MultilingualDocument.class);
        if (!indexOps.exists()) {
            indexOps.create();
            ClassPathResource r = new ClassPathResource("mappings/index-mapping.json");
            String mappingJson = StreamUtils.copyToString(r.getInputStream(), StandardCharsets.UTF_8);
            Document mapping = Document.parse(mappingJson);
            indexOps.putMapping(mapping);
        }
    }
}
