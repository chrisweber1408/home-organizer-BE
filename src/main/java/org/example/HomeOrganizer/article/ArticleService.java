package org.example.HomeOrganizer.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepo articleRepo;
    public void addAnArticle(String nameOfArticle) {
        Article newArticle = new Article(nameOfArticle);
        articleRepo.save(newArticle);
    }

    public Article getAnArticle(String id) {
        return articleRepo.findById(id).orElseThrow();
    }

    public List<Article> getAllArticle() {
        return articleRepo.findAll();
    }
}
