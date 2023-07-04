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


import com.example.demo3.models.User;
import com.example.demo3.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;



@Controller
public class UsersController {
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("getting users");
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "users/showAll";
    }



    @PostMapping("/signup")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response, Model model, @ModelAttribute("user") User user){
        String Name = newuser.get("name");
        String Password = newuser.get("password");
        String Email = newuser.get("email");
        int Age = Integer.parseInt(newuser.get("age"));
        String Location = newuser.get("location");
        userRepo.save(new User(Age, Location, Name, Email, Password) );
        response.setStatus(201);
         model.addAttribute("us", user);
        return "redirect:/userPage.html";
    }
    

@RequestMapping("/ad")
    public String getAdd( Model model){
        return "redirect:/welcome.html";
    }

@RequestMapping("/save")
    public String saveAdd(Model model, @ModelAttribute("user") User user){
        userRepo.save(user);
        List<User> users = userRepo.findAll();
        model.addAttribute("us", users);
        return "users/showAll";
    }



    
    @GetMapping("users/edit/{uid}")
    public String addeditUser(Model model, @PathVariable String uid, RedirectAttributes ra){
  
         
        try {
            int id = Integer.parseInt(uid);
            List<User> us = new ArrayList<>();
            User u = userRepo.findById(id).get();
            model.addAttribute("u", u);
            us.add(u);
            model.addAttribute("us", us);
            userRepo.delete(u);
            return "users/edit";
          
        } catch (Exception e) {
        e.printStackTrace();
        return "users/showAll";
        }

        
    
    }

    @RequestMapping("/edit/{uid}")
    public String gottoedit( Model model, @PathVariable String uid){
        int id = Integer.parseInt(uid);
        User u = userRepo.findById(id).get();
        model.addAttribute("us", u);
        return "redirect:/edit.html/{uid}";
    }

}