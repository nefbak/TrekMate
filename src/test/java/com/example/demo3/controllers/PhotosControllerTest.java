package com.example.demo3.controllers;

package com.example.demo3.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;

import com.example.demo3.storage.FileSystemStorageService;
import com.example.demo3.storage.StorageFileNotFoundException;
import com.example.demo3.storage.StorageService;

@ContextConfiguration(classes = {PhotosController.class})
@ExtendWith(SpringExtension.class)
class PhotosControllerTest {
    @Autowired
    private PhotosController photosController;

    @MockBean
    private StorageService storageService;


    @Test
    void testServeFile2() throws UnsupportedEncodingException {

        FileSystemStorageService storageService = mock(FileSystemStorageService.class);
        when(storageService.loadAsResource(Mockito.<String>any()))
                .thenReturn(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8")));
        ResponseEntity<Resource> actualServeFileResult = (new PhotosController(storageService)).serveFile("foo.txt");
        assertTrue(actualServeFileResult.hasBody());
        assertEquals(200, actualServeFileResult.getStatusCodeValue());
        assertEquals(1, actualServeFileResult.getHeaders().size());
        verify(storageService).loadAsResource(Mockito.<String>any());
    }


    @Test
    void testViewGallery2() {
       
        FileSystemStorageService storageService = mock(FileSystemStorageService.class);
        when(storageService.findAllUserPhotos(anyInt())).thenReturn(new ArrayList<>());
        PhotosController photosController = new PhotosController(storageService);
        assertEquals("users/gallery", photosController.viewGallery(new ConcurrentModel(), 1));
        verify(storageService).findAllUserPhotos(anyInt());
    }


    @Test
    void testHandleStorageFileNotFound() {
        ResponseEntity<?> actualHandleStorageFileNotFoundResult = photosController
                .handleStorageFileNotFound(new StorageFileNotFoundException("An error occurred"));
        assertNull(actualHandleStorageFileNotFoundResult.getBody());
        assertEquals(404, actualHandleStorageFileNotFoundResult.getStatusCodeValue());
        assertTrue(actualHandleStorageFileNotFoundResult.getHeaders().isEmpty());
    }


    @Test
    void testHandleStorageFileNotFound2() {
        ResponseEntity<?> actualHandleStorageFileNotFoundResult = photosController
                .handleStorageFileNotFound(mock(StorageFileNotFoundException.class));
        assertNull(actualHandleStorageFileNotFoundResult.getBody());
        assertEquals(404, actualHandleStorageFileNotFoundResult.getStatusCodeValue());
        assertTrue(actualHandleStorageFileNotFoundResult.getHeaders().isEmpty());
    }
}

