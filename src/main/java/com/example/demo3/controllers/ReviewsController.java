package com.example.demo3.controllers;

import java.util.List;
import java.util.Map;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo3.models.Review;
import com.example.demo3.models.ReviewRepository;
import com.example.demo3.models.User;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReviewsController {
    
    @Autowired
    private ReviewRepository reviewRepo;

  /*  @GetMapping("/trails/view")
    public String getAllTrails(Model model){
        System.out.println("Getting all trails");
        // TODO: get all students from database
        List<Review> reviews = reviewRepo.findAll();
        
        model.addAttribute("re", reviews);
        return "users/trailPage";
    }

    @PostMapping("/users/addTrail")
    public String addTrail(@RequestParam Map<String, String> newtrail, HttpServletResponse response, Model model, @ModelAttribute("trail") Trail trail){
        String Name = newtrail.get("trailName");
        float Lat = Float.parseFloat(newtrail.get("lat"));
        float Lon = Float.parseFloat(newtrail.get("lon"));
        String Location = newtrail.get("area");
        trailRepo.save(new Trail(Name, Lat, Lon, Location));
        response.setStatus(201);
         //model.addAttribute("tr", t);
        //return "redirect:/addTrail.html";
        return "users/addedTrail";
    }

    @GetMapping("/trail/adminView")
    public String getAdminTrail(Model model){
        System.out.println("Getting all trails");
        // TODO: get all students from database
        List<Trail> trails = trailRepo.findAll();
        
        model.addAttribute("tr", trails);
        return "users/adminTrail";
    }

    @PostMapping("/trail/remove")
    public String removeTrail(Model model, @RequestParam(name = "uidd") int tid, HttpServletResponse response){

        System.out.println("d");
        System.out.println("Delete Trail " + tid);
        Trail t = trailRepo.findByTid(tid).get(0);
        trailRepo.delete(t); //delete from database

        return "users/removedTrail";
    } */
}
