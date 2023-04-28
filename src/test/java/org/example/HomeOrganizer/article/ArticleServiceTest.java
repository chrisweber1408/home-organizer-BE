package org.example.HomeOrganizer.article;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleServiceTest {

    @Test
    void shouldAddAnArticle(){
        //given
        ArticleRepo articleRepo = Mockito.mock(ArticleRepo.class);
        ArticleService articleService = new ArticleService(articleRepo);
        //when
        articleService.addAnArticle("testArticle");
        //then
        Mockito.verify(articleRepo, Mockito.times(1)).save(Mockito.any(Article.class));
    }
}