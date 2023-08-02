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

    @GetMapping("/register")
    public String register(Model model){
        return "users/register";
    }



    //@PostMapping("/signup")
    @PostMapping("/signup")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response, Model model, @ModelAttribute("user") User user){
        System.out.println("PLEASE");
        
        String Name = newuser.get("name");
        String Password = newuser.get("password");
        String Email = newuser.get("email");
        String Location = newuser.get("location");
        String Difficulty = newuser.get("difficulty");
        String Age = newuser.get("age");
        System.out.println("EMAIL LENGTH: " + Email.length());
        System.out.println("Age LENGTH: " + newuser.get("age").length());

        if (Age.length()==0){
            System.out.println("OKAY");
            return "users/register";
        }

       /* if (Age.length()==1){
            System.out.println("AYA");
            return "users/register";
        }*/

        if ("".equals(Age)){
            System.out.println("YES");
            return "users/register";
        }

        if (Email.length() == 0 || Name.length()==0 || Password.length() == 0 || Location.length() == 0 || Age.length() == 0 || Difficulty.length() == 0) {
            model.addAttribute("error", "Error: Please don't leave name, password, or email blank");
            System.out.println("What");
            return "users/register";
            
        }
        System.out.println("HUH");
        if (userRepo.findByEmail(Email).size() == 0 && !Email.equals("admin@gmail.com")){
            
            int newAge = Integer.parseInt(Age);

        // User u = userRepo.save(new User(Age, Location, Name, Email, Password, Difficulty) );
            userRepo.save(new User(newAge, Location, Name, Email, Password, Difficulty) );
            User u = userRepo.findByName(Name).get(0);
            int userId = u.getUid(); // Retrieve the generated ID
            u.setUid(userId); 
            System.out.println("WOAH "+u.getUid());
            response.setStatus(201);
        // u.setUid(u.getUid());
            model.addAttribute("us", u);
            model.addAttribute("ud", userId);
            //return "redirect:/userPage.html";
            return "users/userPage";
        }
        System.out.println("Hi");
        model.addAttribute("error", "Error: email is already in use");
        return "users/register";
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> newuser, HttpServletResponse response, Model model, @ModelAttribute("user") User user){
       // String Name = newuser.get("name");
        String Email = newuser.get("email");
        String Password = newuser.get("password");
        //System.out.println("Name "+Name);
        System.out.println("Pass: "+Password);
        //System.out.println("Findbyname: "+userRepo.findByName(Name).size());
        
        /*String adName= "admin";
        String adPass = "admin";

        if (Password.equals(adPass) && Name.equals(adName)){
            List<User> users = userRepo.findAll();
        
            model.addAttribute("us", users);
            return "users/admin";
        }

        if (userRepo.findByName(Name).size() != 0){
         User u = userRepo.findByName(Name).get(0);
        
        System.out.println("User Repo find: " + u.getName());
        System.out.println("HI " + u.getPassword());
        String be = u.getPassword();

        if (Password.equals(be)){
            System.out.println("PLEASE");
            model.addAttribute("user", u);
            model.addAttribute("ud", u.getUid());
            return "users/userPage";
        }
        response.setStatus(201);
        model.addAttribute("us", u);
        //return "redirect:/userPage.html";
    }
        return "redirect:/welcome.html"; */

        String adEmail= "admin@gmail.com";
        String adPass = "admin";

        if (Password.equals(adPass) && Email.equals(adEmail)){
            List<User> users = userRepo.findAll();
        
            model.addAttribute("us", users);
            return "users/admin";
        }

        if (userRepo.findByEmail(Email).size() != 0){
         User u = userRepo.findByEmail(Email).get(0);
        
        System.out.println("User Repo find: " + u.getEmail());
        System.out.println("HI " + u.getPassword());
        String be = u.getPassword();

        if (Password.equals(be)){
            System.out.println("PLEASE");
            model.addAttribute("user", u);
            model.addAttribute("ud", u.getUid());
            return "users/userPage";
        }
        response.setStatus(201);
        model.addAttribute("us", u);
        //return "redirect:/userPage.html";
    }
        return "redirect:/welcome.html"; 
    }

    @GetMapping("/users/viewAdmin")
    public String getAllUsersAdmin(Model model){
        System.out.println("getting users");
        List<User> users = userRepo.findAll();
        model.addAttribute("us", users);
        return "users/admin";
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

    @PostMapping("/users/{uid}")
    public String viewUser(Model model, @RequestParam(name = "uiddd") String uid, HttpServletResponse response){

        System.out.println("s");
        System.out.println("Get User " + uid);
        int id = Integer.parseInt(uid);
        User u = userRepo.findById(id).get();

        model.addAttribute("user", u);
        model.addAttribute("ud", u.getUid());
        return "users/userPage";
    }

    @PostMapping("/users/{uid}/other")
    public String viewUserOther(Model model, @RequestParam Map<String, String> newuser, HttpServletResponse response){
        String uid = newuser.get("uiddd");
        String uog = newuser.get("uog");
        String tid = newuser.get("ti");
        String name = newuser.get("name");
        System.out.println("s");
        //System.out.println("Get User " + uid);
        int id = Integer.parseInt(uid);
        int idog = Integer.parseInt(uog);
         if (userRepo.findByUid(id).size() != 0){
            User u = userRepo.findById(id).get();

            model.addAttribute("user", u);
            model.addAttribute("ud", u.getUid());
            model.addAttribute("uOg", idog);
            model.addAttribute("name", name);
            model.addAttribute("tid", tid);
            return "users/userPageOther";
         }
         model.addAttribute("name", name);
         model.addAttribute("ud", uog);
         model.addAttribute("tid", tid);
         return "users/userPageNotFound";
    }
    
    @PostMapping("/user/admin/profile")
    public String viewUserAdmin(Model model, @RequestParam(name = "uiddd") String uid, HttpServletResponse response){

        System.out.println("s");
        System.out.println("Get User " + uid);
        int id = Integer.parseInt(uid);
        User u = userRepo.findById(id).get();

        model.addAttribute("user", u);
        model.addAttribute("ud", u.getUid());
        return "users/userPageAdmin";
    }



    
   /*  @GetMapping("users/edit/{uid}")
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
    } */

     @GetMapping("/user/adminView")
    public String getAdmin(Model model){
        System.out.println("Getting all students");
        // TODO: get all students from database
        List<User> users = userRepo.findAll();
        
        model.addAttribute("us", users);
        return "users/admin";
    }

    @PostMapping("/user/remove")
    public String removeUser(Model model, @RequestParam(name = "uidd") int uid, HttpServletResponse response){

        System.out.println("d");
        System.out.println("Delete User " + uid);
        User u = userRepo.findByUid(uid).get(0);
        userRepo.delete(u); //delete from database

        return "users/removedUser";
    }

    //@PostMapping("/user/userPage/{uid}/edit")
    @PostMapping("users/edit/{uid}")
    public String editUsers(Model model, @PathVariable(name = "uid") int uid, HttpServletResponse response){
        //List<Student> student = studentRepo.findByUid(uid);  
        System.out.println("s");
        System.out.println("Get UID STRING " + uid);
        //int id = Integer.parseInt(uid);
        System.out.println("Get User " + uid);
        User u = userRepo.findById(uid).get();
        System.out.println("HELLO" + u.getName());

        model.addAttribute("user", u);
        //return "showUser";
        return "users/edit";
    }

    @PostMapping("/user/userPage/{uid}/edited")
    public String editedStudent(Model model, @RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("Edit user");
        String newName = newuser.get("name");
        System.out.println("NAME: " + newName);
        String newEmail = newuser.get("email");
        System.out.println("EMAIL: " + newEmail);
        String newDifficulty = newuser.get("difficulty");
       // System.out.println("DIFFICULTY: " + newDifficulty);
        String newLocation = newuser.get("location");
       // System.out.println("LOCATION: " + newLocation);
        String tempAge = newuser.get("age");
       // System.out.println("AGE: " + tempAge);
        String tempId = newuser.get("idddd");
        //System.out.println("ID: " + tempId);
        String pass = newuser.get("password");
        //System.out.println("Password: " + pass);
        int id = Integer.parseInt(tempId);
        
        if (tempAge.length() == 0 || newDifficulty.length() == 0 || newName.length() == 0 || newLocation.length() == 0 || newEmail.length() == 0) {
            model.addAttribute("error", "Please ensure all input fields are filled");
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        }
        if (tempAge.matches(".*[^0-9.].*")){
            model.addAttribute("error", "Invalid age input (non-numerical characters)");
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        } 
        int newAge = Integer.parseInt(newuser.get("age"));

        /*if (newAge < 18){
            String error = "Invalid age (under 18)";
            model.addAttribute("error", error);
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        } */

         if (newEmail.toLowerCase().indexOf(".com") == -1 && newEmail.toLowerCase().indexOf(".ca") == -1 && newEmail.toLowerCase().indexOf("@") == -1) {
            String error = "Invalid email input (no @ symbol, .com or .ca)";
            model.addAttribute("error", error);
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        } else if (newEmail.toLowerCase().indexOf(".com") == -1 && newEmail.toLowerCase().indexOf(".ca") == -1) {
            String error = "Invalid email input (no .com or .ca)";
            model.addAttribute("error", error);
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        } else if (newEmail.toLowerCase().indexOf("@") == -1) {
            String error = "Invalid email input (no @ symbol)";
            model.addAttribute("error", error);
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        }

        User u = userRepo.findById(id).get();

        //userRepo.delete(u); //delete from database

        u.setAge(newAge);

        u.setDifficulty(newDifficulty);

        u.setEmail(newEmail);

        u.setName(newName);

        u.setPassword(pass);

        u.setLocation(newLocation);

        //User us = userRepo.save(us(newAge, newLocation, newName, newEmail, pass, newDifficulty));

        userRepo.save(u);
        
        model.addAttribute("user", u);

        return "users/edited";
    } 

    @PostMapping("users/trailS/{uid}")
        public String trailSearch(Model model, @PathVariable(name = "uid") int uid, HttpServletResponse response){
        //List<Student> student = studentRepo.findByUid(uid);
        System.out.println("s");
        System.out.println("Get UID STRING " + uid);
        //int id = Integer.parseInt(uid);
        System.out.println("Get User " + uid);
        User u = userRepo.findById(uid).get();
        System.out.println("HELLO" + u.getName());

        model.addAttribute("user", u);
        model.addAttribute("ud", uid);
        //return "showUser";
        return "users/trailSearch";
    }

}