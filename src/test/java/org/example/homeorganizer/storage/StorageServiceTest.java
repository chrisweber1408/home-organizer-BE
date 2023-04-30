package org.example.homeorganizer.storage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class StorageServiceTest {

    @Test
    void shouldAddAStorage(){
        //given
        StorageRepo storageRepo = mock(StorageRepo.class);
        StorageService storageService = new StorageService(storageRepo);
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
        StorageService storageService = new StorageService(storageRepo);
        when(storageRepo.findById("123")).thenReturn(Optional.of(storage));
        //when
        Storage result = storageService.getAStorage("123");
        //then
        assertThat(result).isEqualTo(storage);
    }
}