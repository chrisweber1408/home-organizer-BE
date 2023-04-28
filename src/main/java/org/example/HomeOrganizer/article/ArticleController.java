package org.example.HomeOrganizer.article;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/add/{nameOfArticle}")
    public void addAArticle(@PathVariable String nameOfArticle){
        articleService.addAArticle(nameOfArticle);
    }
}