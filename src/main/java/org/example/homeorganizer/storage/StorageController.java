package org.example.homeorganizer.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage")
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/add/{storageName}")
    public void addAStorage(@PathVariable String storageName){
        storageService.addAStorage(storageName);
    }

    @GetMapping("/get/{storageId}")
    public Storage getAStorage(@PathVariable String storageId){
        return storageService.getAStorage(storageId);
    }

    @GetMapping("/getAll")
    public List<Storage> getAllStorages(){
        return storageService.getAllStorages();
    }

    @PatchMapping("/add/{storageId}/{articleId}")
    public void addArticleIntoStorage(@PathVariable String storageId,@PathVariable String articleId){
        storageService.addArticleIntoStorage(storageId, articleId);
    }

}
