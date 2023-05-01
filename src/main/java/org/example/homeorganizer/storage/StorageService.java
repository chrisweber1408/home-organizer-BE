package org.example.homeorganizer.storage;

import lombok.RequiredArgsConstructor;
import org.example.homeorganizer.article.Article;
import org.example.homeorganizer.article.ArticleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepo storageRepo;
    private final ArticleRepo articleRepo;

    public void addAStorage(String storageName) {
        Storage storage = new Storage(storageName);
        storageRepo.save(storage);
    }

    public Storage getAStorage(String id) {
        return storageRepo.findById(id).orElseThrow();
    }

    public List<Storage> getAllStorages() {
        return storageRepo.findAll();
    }

    public void addArticleIntoStorage(String storageId, String articleId) {
        Storage storage = storageRepo.findById(storageId).orElseThrow();
        Article article = articleRepo.findById(articleId).orElseThrow();
        storage.addAnArticle(article);
        storageRepo.save(storage);
    }
}
