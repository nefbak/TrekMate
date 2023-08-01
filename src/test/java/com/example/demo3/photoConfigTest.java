package com.example.demo3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

class photoConfigTest {

    @Test
    void testAddResourceHandlers() {

        photoConfig photoConfig = new photoConfig();

        AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
        ResourceHandlerRegistry registry = new ResourceHandlerRegistry(applicationContext, new MockServletContext());

        photoConfig.addResourceHandlers(registry);
        assertFalse(registry.hasMappingForPattern("Path Pattern"));
    }


    @Test
    void testAddResourceHandlers2() {

        photoConfig photoConfig = new photoConfig();

        AnnotationConfigApplicationContext applicationContext = mock(AnnotationConfigApplicationContext.class);
        ResourceHandlerRegistry registry = new ResourceHandlerRegistry(applicationContext, new MockServletContext());

        photoConfig.addResourceHandlers(registry);
        assertFalse(registry.hasMappingForPattern("Path Pattern"));
    }


    @Test
    void testExposeDirectory() {

        photoConfig photoConfig = new photoConfig();

        AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
        ResourceHandlerRegistry registry = new ResourceHandlerRegistry(applicationContext, new MockServletContext());

        photoConfig.exposeDirectory("Dir Name", registry);
        assertFalse(registry.hasMappingForPattern("Path Pattern"));
    }


    @Test
    void testExposeDirectory2() {

        photoConfig photoConfig = new photoConfig();

        AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
        ResourceHandlerRegistry registry = new ResourceHandlerRegistry(applicationContext, new MockServletContext());

        photoConfig.exposeDirectory("../", registry);
        assertFalse(registry.hasMappingForPattern("Path Pattern"));
    }

    @Test
    void testExposeDirectory3() {

        photoConfig photoConfig = new photoConfig();

        AnnotationConfigApplicationContext applicationContext = mock(AnnotationConfigApplicationContext.class);
        ResourceHandlerRegistry registry = new ResourceHandlerRegistry(applicationContext, new MockServletContext());

        photoConfig.exposeDirectory("Dir Name", registry);
        assertFalse(registry.hasMappingForPattern("Path Pattern"));
    }

}

