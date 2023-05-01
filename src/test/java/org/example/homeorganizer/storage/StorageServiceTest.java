package org.example.homeorganizer.storage;

import org.example.homeorganizer.article.Article;
import org.example.homeorganizer.article.ArticleRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class StorageServiceTest {

    @Test
    void shouldAddAStorage(){
        //given
        StorageRepo storageRepo = mock(StorageRepo.class);
        ArticleRepo articleRepo = mock(ArticleRepo.class);
        StorageService storageService = new StorageService(storageRepo, articleRepo);
        //when
        storageService.addAStorage("Test123");
        //then
        verify(storageRepo, times(1)).save(any(Storage.class));
    }

    @Test
    void shouldGetAStorage(){
        //given
        Storage storage = new Storage("Schrank");
        StorageRepo storageRepo = mock(StorageRepo.class);
        ArticleRepo articleRepo = mock(ArticleRepo.class);
        StorageService storageService = new StorageService(storageRepo, articleRepo);
        when(storageRepo.findById("123")).thenReturn(Optional.of(storage));
        //when
        Storage result = storageService.getAStorage("123");
        //then
        assertThat(result).isEqualTo(storage);
    }

    @Test
    void shouldGetAllStorages(){
        //given
        Storage storage = new Storage("Schrank");
        StorageRepo storageRepo = mock(StorageRepo.class);
        ArticleRepo articleRepo = mock(ArticleRepo.class);
        StorageService storageService = new StorageService(storageRepo, articleRepo);
        when(storageRepo.findAll()).thenReturn(List.of(storage));
        //when
        List<Storage> result = storageService.getAllStorages();
        //then
        assertThat(result).hasSize(1);
    }

    @Test
    void shouldAddAnArticleIntoAStorage(){
        //given
        Storage storage = new Storage("Schrank");
        Article article = new Article("Block");
        StorageRepo storageRepo = mock(StorageRepo.class);
        ArticleRepo articleRepo = mock(ArticleRepo.class);
        StorageService storageService = new StorageService(storageRepo, articleRepo);
        when(storageRepo.findById(storage.getId())).thenReturn(Optional.of(storage));
        when(articleRepo.findById(article.getId())).thenReturn(Optional.of(article));
        //when
        storageService.addArticleIntoStorage(storage.getId(), article.getId());
        //then
        verify(storageRepo, times(1)).save(any(Storage.class));
    }
}