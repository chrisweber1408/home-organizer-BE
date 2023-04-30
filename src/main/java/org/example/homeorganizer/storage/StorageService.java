package org.example.homeorganizer.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepo storageRepo;

    public void addAStorage(String storageName) {
        Storage storage = new Storage(storageName);
        storageRepo.save(storage);
    }

    public Storage getAStorage(String id) {
        return storageRepo.findById(id).orElseThrow();
    }
}
