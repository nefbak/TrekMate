package com.example.demo3.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo3.models.Photo;
import com.example.demo3.storage.StorageFileNotFoundException;
import com.example.demo3.storage.StorageService;

import jakarta.servlet.http.HttpServletResponse;

/*note to self: the htmls i made are:
    - photoSuccess
    - addPhoto

*/

@Controller
public class PhotosController {
    private final StorageService storageService;
    
    @Autowired
    public PhotosController(StorageService storageService){
        this.storageService = storageService;
    }

    @PostMapping("/users/{ud}/addPhoto")
    public String uploadPhotoForm(Model model, @RequestParam Map<String, String> incomingUser, HttpServletResponse response){
        int uid = Integer.parseInt(incomingUser.get("uiddd"));
        int tid = Integer.parseInt(incomingUser.get("tiddd"));
        model.addAttribute("ud", uid);
        model.addAttribute("td", tid);
        response.setStatus(201);
        return "users/addPhoto";
    }

    @GetMapping("/users/{ud}/addPhoto")
    public String listUploadPhotos(Model model) throws IOException {
        model.addAttribute("files", storageService.loadAll().map(path 
        -> MvcUriComponentsBuilder.fromMethodName(PhotosController.class,"serveFile", path.getFileName()
        .toString()).build().toUri().toString()).collect(Collectors.toList()));
        return "users/addPhoto";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + file.getFilename()
        + "\"").body(file);
    }

    @PostMapping("/users/{ud}/addingPhoto")
    public String handlePhotoUpload(Model model, @RequestParam Map<String, String> incomingUser, @RequestParam("file") MultipartFile file,
        HttpServletResponse response) {
        int uid = Integer.parseInt(incomingUser.get("uiddd"));
        String filename = file.getOriginalFilename();
        int tid = Integer.parseInt(incomingUser.get("tiddd"));
        storageService.store(file);
        
        storageService.sendToRepo(uid, tid, filename);
        //List<Review> userPhoto = photoRepo.findByUid(uid);
        System.out.println(filename);
        String message = "You successfully uploaded " + file.getOriginalFilename()+ "~";
        //redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename()+ "~");
        model.addAttribute("message", message);
        model.addAttribute("ud", uid);
        model.addAttribute("td", tid);
        model.addAttribute("filename", filename);
        response.setStatus(201);
        return "users/photoSuccess";
    }

    @GetMapping("users/{ud}/gallery")
    public String viewGallery(Model model, @PathVariable("ud") int ud){
        System.out.println("Getting all photos");
        // TODO: get all photos of user from database
        List<Photo> gallery = storageService.findAllUserPhotos(ud);
        model.addAttribute("gal", gallery);
        return "users/gallery";
    }


    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc){
        return ResponseEntity.notFound().build();
    }
}
