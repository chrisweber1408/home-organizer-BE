package org.example.HomeOrganizer.article;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Article {
    @Id
    private final String id = UUID.randomUUID().toString();
    private String name;
}
