package org.example.homeorganizer.storage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class StorageServiceTest {

    @Test
    void shouldAddAStorage() {
        StorageRepo storageRepo = mock(StorageRepo.class);
        StorageService storageService = new StorageService(storageRepo);
        //when
        storageService.addAStorage("Test123");
        //then
        verify(storageRepo, times(1)).save(any(Storage.class));
    }
}