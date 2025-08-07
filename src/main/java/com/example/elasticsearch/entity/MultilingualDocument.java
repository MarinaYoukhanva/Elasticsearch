package com.example.elasticsearch.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.HashMap;
import java.util.Map;

@Document(indexName = "multilingual_docs")
@Setter
@Getter
public class MultilingualDocument {

    @Id
    private String identifier;

    @Field(type = FieldType.Object)
    private Map<String, String> body = new HashMap<>();
}
