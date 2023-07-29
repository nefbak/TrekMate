package com.example.demo3.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo3.models.Friend;
import com.example.demo3.models.FriendRepository;
import com.example.demo3.models.Review;

import jakarta.servlet.http.HttpServletResponse;

public class FriendsController {

    @Autowired
    private FriendRepository friendRepo;

    /*@PostMapping("/followed")
    public String followed(@RequestParam Map<String, String> newfriend, HttpServletResponse response, Model model, @ModelAttribute("friend") Friend friend){
        String uName = newfriend.get("uname");
        int uid = Integer.parseInt(newfriend.get("uiddd"));
        int fuid = Integer.parseInt(newfriend.get("fuid"));
        String fName = newfriend.get("uname");

        if (friendRepo.findByUid(uid).size() != 0){
            Friend f = friendRepo.findByUid(uid).get(0);
            List<Integer> uids = f.getFuids();
            if (uids.contains(fuid)){
                model.addAttribute("ud", uid);
                model.addAttribute("uid", fuid);
                model.addAttribute("message", "You have already followed this account");
            } else {

            }

        }
       /* int tid = Integer.parseInt(newreview.get("tiddd"));
        String difficulty = newreview.get("difficulty");
        String date = newreview.get("date");
        String paragraph = newreview.get("paragraph");
        reviewRepo.save(new Review(name, date, location, difficulty, paragraph, tid, uid));
        model.addAttribute("ud", uid);
        model.addAttribute("tid", tid);
        model.addAttribute("name", name);
        return "users/addedReview"; 
    } */
}