package org.example.homeorganizer.storage;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.homeorganizer.article.Article;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    @Id
    private final String id = UUID.randomUUID().toString();
    private String name;
    @OneToMany
    @Nullable
    private List<Article> articleList;

    public Storage(String name) {
        this.name = name;
    }
}
