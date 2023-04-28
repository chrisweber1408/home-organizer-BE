package org.example.HomeOrganizer.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepo articleRepo;
    public void addAArticle(String nameOfArticle) {
        Article newArticle = new Article(nameOfArticle);
        articleRepo.save(newArticle);
    }
}
