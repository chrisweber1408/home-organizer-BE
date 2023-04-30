package org.example.homeorganizer.storage;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.homeorganizer.article.Article;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
public class Storage {

    @Id
    private final String id = UUID.randomUUID().toString();
    private final String name;
    private List<Article> articleList;


}
