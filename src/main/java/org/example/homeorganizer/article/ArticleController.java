package org.example.homeorganizer.article;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/add/{nameOfArticle}")
    public void addAnArticle(@PathVariable String nameOfArticle){
        articleService.addAnArticle(nameOfArticle);
    }

    @GetMapping("/get/{id}")
    public Article getAnArticle(@PathVariable String id){
        return articleService.getAnArticle(id);
    }

    @GetMapping("/getAll")
    public List<Article> getAllArticle(){
        return articleService.getAllArticle();
    }

}
