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


    @PostMapping("/users/{ud}/review")
    public String addReview(@RequestParam Map<String, String> newreview, HttpServletResponse response, Model model, @ModelAttribute("review") Review review){
        String name = newreview.get("name");
        String location = newreview.get("location");
        int uid = Integer.parseInt(newreview.get("uiddd"));
        int tid = Integer.parseInt(newreview.get("tiddd"));
        model.addAttribute("name", name);
        model.addAttribute("location", location);
        model.addAttribute("ud", uid);
        model.addAttribute("tid", tid);
        return "users/hikeExp";
    }

    @PostMapping("/users/{ud}/allReviews")
    public String getAllReviews(@RequestParam Map<String, String> newreview, HttpServletResponse response, Model model, @ModelAttribute("review") Review review){
        System.out.println("getting reviews");
        int uid = Integer.parseInt(newreview.get("uiddd"));
        int tid = Integer.parseInt(newreview.get("tiddd"));
        String name = newreview.get("name");
        System.out.println("TEST: " + name);
        List<Review> reviews = reviewRepo.findByTid(tid);
        model.addAttribute("reviews", reviews);
        model.addAttribute("ud", uid);
        model.addAttribute("tid", tid);
        model.addAttribute("name", name);
        return "users/reviewDisplay";
    }

    @PostMapping("/users/{ud}/userReviews")
    public String getAllUserReviews(@RequestParam Map<String, String> newreview, HttpServletResponse response, Model model, @ModelAttribute("review") Review review){
        System.out.println("getting reviews");
        int uid = Integer.parseInt(newreview.get("uiddd"));
        //int tid = Integer.parseInt(newreview.get("tiddd"));
        //String name = newreview.get("name");
        //System.out.println("TEST: " + name);
        List<Review> reviews = reviewRepo.findByUid(uid);
        model.addAttribute("reviews", reviews);
        model.addAttribute("ud", uid);
       // model.addAttribute("tid", tid);
        //model.addAttribute("name", name);
        return "users/hikeHistory";
    }

    @PostMapping("/postReview")
    public String reviewed(@RequestParam Map<String, String> newreview, HttpServletResponse response, Model model, @ModelAttribute("review") Review review){
        String name = newreview.get("trailName");
        String location = newreview.get("location");
        int uid = Integer.parseInt(newreview.get("uiddd"));
        int tid = Integer.parseInt(newreview.get("tiddd"));
        String difficulty = newreview.get("difficulty");
        String date = newreview.get("date");
        String paragraph = newreview.get("paragraph");
        reviewRepo.save(new Review(name, date, location, difficulty, paragraph, tid, uid));
        model.addAttribute("ud", uid);
        model.addAttribute("tid", tid);
        model.addAttribute("name", name);
        return "users/addedReview";
    }

    @PostMapping("/review/remove")
    public String removeReview(@RequestParam Map<String, String> newreview, HttpServletResponse response, Model model, @ModelAttribute("review") Review review){
        int rid = Integer.parseInt(newreview.get("ridd"));
        int uid = Integer.parseInt(newreview.get("uidd"));
        System.out.println("d");
        System.out.println("Delete Review " + rid);
        Review r = reviewRepo.findByRid(rid).get(0);
        reviewRepo.delete(r); //delete from database
        model.addAttribute("ud", uid);
        return "users/removedReview";
    }

    

}
