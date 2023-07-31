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

import com.example.demo3.models.Group;
import com.example.demo3.models.GroupRepository;
import com.example.demo3.models.Review;
import com.example.demo3.models.User;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class GroupsController {
    
    @Autowired
    private GroupRepository groupRepo;


    @PostMapping("/addedGroup")
    public String addedGroup(@RequestParam Map<String, String> newgroup, HttpServletResponse response, Model model, @ModelAttribute("group") Group group){
        
        int size = Integer.parseInt(newgroup.get("size"));

        System.out.println("SIZE: " + size);

        if (size > 1) {
            System.out.println("Check");
            String trailName = newgroup.get("trailName");
            String name = newgroup.get("name");
            String location = newgroup.get("location");
            String date = newgroup.get("date");
            int tid = Integer.parseInt(newgroup.get("tiddd"));
            int uid = Integer.parseInt(newgroup.get("uiddd"));
            String difficulty = newgroup.get("difficulty");
            //int[] uids = new int[size];
            List<Integer> uids = new ArrayList<>();
            uids.add(uid);
            groupRepo.save(new Group(uids, date, name, location, trailName, difficulty, tid, size));
            model.addAttribute("ud", uid);
            model.addAttribute("tid", tid);
            model.addAttribute("message", "Group Successfully Added");
            return "users/addedGroup";
        }

        String trailName = newgroup.get("trailName");
        String location = newgroup.get("location");
        int tid = Integer.parseInt(newgroup.get("tiddd"));
        int uid = Integer.parseInt(newgroup.get("uiddd"));
        model.addAttribute("ud", uid);
        model.addAttribute("tid", tid);
        model.addAttribute("location", location);
        model.addAttribute("trailName", trailName);
        return "users/groupPage2";
    }

    @PostMapping("/joinGroup")
    public String joinGroup(@RequestParam Map<String, String> newgroup, HttpServletResponse response, Model model, @ModelAttribute("group") Group group){
        
        int uid = Integer.parseInt(newgroup.get("uiddd"));

        int gid = Integer.parseInt(newgroup.get("gid"));

        int tid = Integer.parseInt(newgroup.get("tiddd"));
            
            Group g = groupRepo.findByGid(gid).get(0);

            int size = g.getUids().size();

            List<Integer> u = g.getUids();

            if (size == g.getSize()) {
                model.addAttribute("message", "Unable to join group, this group is full");
                model.addAttribute("ud", uid);
                 model.addAttribute("tid", tid);
                return "users/addedGroup";
            } else if (u.contains(uid)) {
                model.addAttribute("message", "You are already in this group");
                model.addAttribute("ud", uid);
                model.addAttribute("tid", tid);
                return "users/addedGroup";
            }

        // User u = userRepo.save(new User(Age, Location, Name, Email, Password, Difficulty) );
            u.add(uid);

            g.setUids(u);

            groupRepo.save(g);

             
            model.addAttribute("ud", uid);
            model.addAttribute("tid", tid);
            model.addAttribute("message", "Successfully Joined Group");
            //return "redirect:/userPage.html";
            return "users/addedGroup";
    }

    @PostMapping("/users/{ud}/trailGroups")
    public String getAllGroups(@RequestParam Map<String, String> newgroup, HttpServletResponse response, Model model, @ModelAttribute("group") Group group){
        System.out.println("getting groups");
        int uid = Integer.parseInt(newgroup.get("uiddd"));
        int tid = Integer.parseInt(newgroup.get("tiddd"));
        //String name = newgroup.get("name");
        String location = newgroup.get("location");
        String trailName = newgroup.get("trailName");

        //System.out.println("TEST: " + name);
        List<Group> groups = groupRepo.findByTid(tid);
        model.addAttribute("groups", groups);
        model.addAttribute("ud", uid);
        model.addAttribute("tid", tid);
        //model.addAttribute("name", name);
        model.addAttribute("location", location);
        model.addAttribute("trailName", trailName);
        return "users/groupPage2";
    }

    @PostMapping("/group/remove")
    public String removeGroup(@RequestParam Map<String, String> newgroup, HttpServletResponse response, Model model, @ModelAttribute("group") Group group){
        int gid = Integer.parseInt(newgroup.get("gidd"));
        int uid = Integer.parseInt(newgroup.get("uidd"));
        //String suid = newgroup.get("uiddd");
        System.out.println("d");
        System.out.println("Delete Group " + uid);
        //Group g = groupRepo.findByUidsContaining(uid).get(0);
        Group g = groupRepo.findByGid(gid).get(0);
        List<Integer> uids = g.getUids();
        uids.remove(Integer.valueOf(uid));
        g.setUids(uids);
        groupRepo.save(g); //delete from database
        model.addAttribute("ud", uid);
        return "users/removedGroup";
    }

    @PostMapping("/users/{ud}/userGroups")
    public String getAllUserGroups(@RequestParam Map<String, String> newgroup, HttpServletResponse response, Model model, @ModelAttribute("group") Group group){
        System.out.println("getting groups");
        String suid = newgroup.get("uiddd");
        int uid = Integer.parseInt(newgroup.get("uiddd"));
        //int tid = Integer.parseInt(newgroup.get("tiddd"));
        //String name = newgroup.get("name");
       // String location = newgroup.get("location");
        //String trailName = newgroup.get("trailName");

        //System.out.println("TEST: " + name);
        //List<Group> groups = groupRepo.getAllByUids(suid);
        List<Group> groups = groupRepo.findByUidsContaining(uid);
        model.addAttribute("groups", groups);
        model.addAttribute("ud", uid);
        //model.addAttribute("tid", tid);
        //model.addAttribute("name", name);
        //model.addAttribute("location", location);
        //model.addAttribute("trailName", trailName);
        return "users/groupPage";
    }

    @PostMapping("/users/{ud}/addGroup")
    public String addGroup(@RequestParam Map<String, String> newgroup, HttpServletResponse response, Model model, @ModelAttribute("group") Group group){
        int uid = Integer.parseInt(newgroup.get("uiddd"));
        int tid = Integer.parseInt(newgroup.get("tiddd"));
        String location = newgroup.get("location");
        String trailName = newgroup.get("trailName");

        model.addAttribute("ud", uid);
        model.addAttribute("tid", tid);
        model.addAttribute("location", location);
        model.addAttribute("trailName", trailName);
        return "users/groupsAdd";
    }

    /*@PostMapping("/users/{ud}/allReviews")
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

    @PostMapping("/users/{ud}/userReviewsAdmin")
    public String getAllUserReviewsAdmin(@RequestParam Map<String, String> newreview, HttpServletResponse response, Model model, @ModelAttribute("review") Review review){
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
        return "users/hikeHistoryAdmin";
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

    @PostMapping("/review/removeAdmin")
    public String removeReviewAdmin(@RequestParam Map<String, String> newreview, HttpServletResponse response, Model model, @ModelAttribute("review") Review review){
        int rid = Integer.parseInt(newreview.get("ridd"));
        int uid = Integer.parseInt(newreview.get("uidd"));
        System.out.println("d");
        System.out.println("Delete Review " + rid);
        Review r = reviewRepo.findByRid(rid).get(0);
        reviewRepo.delete(r); //delete from database
        model.addAttribute("ud", uid);
        return "users/removedReviewAdmin";
    } */

    

}