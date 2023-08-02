package com.example.demo3.storage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo3.models.Photo;
import com.example.demo3.models.PhotoRepository;

@ContextConfiguration(classes = {FileSystemStorageService.class, StorageProperties.class})
@ExtendWith(SpringExtension.class)
class StorageServiceTest {
    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @MockBean
    private PhotoRepository photoRepository;

    @Autowired
    private StorageProperties storageProperties;


    @Test
    void testStore() throws IOException {
        assertThrows(StorageException.class, () -> fileSystemStorageService
                .store(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
        assertThrows(StorageException.class, () -> fileSystemStorageService
                .store(new MockMultipartFile("Name", new ByteArrayInputStream(new byte[]{}))));
    }



    @Test
    void testLoadAll() {
        assertThrows(StorageException.class,
                () -> fileSystemStorageService.loadAll());
    }


    @Test
    void testLoad() {

        fileSystemStorageService.load("foo.txt");
    }


    @Test
    void testLoadAsResource() {
        assertThrows(StorageFileNotFoundException.class,
                () -> fileSystemStorageService.loadAsResource("foo.txt"));
    }


    @Test
    void testDeleteAll() {

        fileSystemStorageService.deleteAll();
    }

    @Test
    void testSendToRepo() {
        when(photoRepository.save(Mockito.<Photo>any())).thenReturn(new Photo(1, 1, "foo.txt"));
        fileSystemStorageService.sendToRepo(1, 1, "foo.txt");
        verify(photoRepository).save(Mockito.<Photo>any());
    }


    @Test
    void testSendToRepoTrowsExeption() {
        when(photoRepository.save(Mockito.<Photo>any())).thenThrow(new StorageException("An error occurred"));
        assertThrows(StorageException.class, () -> fileSystemStorageService.sendToRepo(1, 1, "foo.txt"));
        verify(photoRepository).save(Mockito.<Photo>any());
    }


    @Test
    void testFindAllUserPhotos() {
        ArrayList<Photo> photoList = new ArrayList<>();
        when(photoRepository.findByUid(anyInt())).thenReturn(photoList);

        List<Photo> actualFindAllUserPhotosResult = fileSystemStorageService.findAllUserPhotos(1);

        assertSame(photoList, actualFindAllUserPhotosResult);
        assertTrue(actualFindAllUserPhotosResult.isEmpty());
        verify(photoRepository).findByUid(anyInt());
    }


    @Test
    void testFindAllUserPhotosTrowsExeption() {
        when(photoRepository.findByUid(anyInt())).thenThrow(new StorageException("An error occurred"));
        assertThrows(StorageException.class, () -> fileSystemStorageService.findAllUserPhotos(1));
        verify(photoRepository).findByUid(anyInt());
    }
}

