package org.example.HomeOrganizer.article;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArticleServiceTest {

    @Test
    void shouldAddAnArticle(){
        //given
        ArticleRepo articleRepo = mock(ArticleRepo.class);
        ArticleService articleService = new ArticleService(articleRepo);
        //when
        articleService.addAnArticle("testArticle");
        //then
        verify(articleRepo, times(1)).save(any(Article.class));
    }

    @Test
    void shouldGetAnArticleById(){
        //given
        Article article = new Article("test");
        ArticleRepo articleRepo = mock(ArticleRepo.class);
        ArticleService articleService = new ArticleService(articleRepo);
        when(articleRepo.findById("123")).thenReturn(Optional.of(article));
        //when /then
        assertThat(articleService.getAnArticle("123")).isEqualTo(article);
    }
    
    @Test
    void shouldGetAllArticle(){
        //given
        Article article1 = new Article("test1");
        Article article2 = new Article("test2");
        Article article3 = new Article("test3");
        ArticleRepo articleRepo = mock(ArticleRepo.class);
        ArticleService articleService = new ArticleService(articleRepo);
        when(articleRepo.findAll()).thenReturn(List.of(article1, article2, article3));
        //when /then
        assertThat(articleService.getAllArticle()).hasSize(3);
    }
}