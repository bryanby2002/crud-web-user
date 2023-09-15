package com.miapp.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.miapp.crud.model.User;
import com.miapp.crud.service.myService;

@Controller
public class myController {
  
  @Autowired
  private myService service;

  //Mapping for list users
  @GetMapping("/home")
  public String listUsers(Model model){
    model.addAttribute("users", this.service.getUserAll());
    return "index";
  }

  //Mapping for view form register user
  @GetMapping("/home/new")
  public String viewFormNewUser(Model model){
    User user = new User();
    model.addAttribute("user", user);
    return "newUser";
  }

  //Mapping for new user
  @PostMapping("/home")
  public String registerNewUser(@ModelAttribute("user") User user){
    this.service.saveUser(user);
    return "redirect:/home";
  }

  //Mapping for view the form update user
  @GetMapping("/home/update/{id}")
  public String viewFormUpdateUser(@PathVariable Long id, Model model){
    model.addAttribute("user", this.service.getUserById(id));
    return "updateUser";
  }

  //Mapping for udpate user
  @PostMapping("/home/{id}")
  public String updateUserById(@PathVariable Long id, @ModelAttribute("user") User user, Model model){
    User userExist = new User();
    userExist.setId(id);
    userExist.setEmail(user.getEmail());
    userExist.setUsername(user.getUsername());
    this.service.updateUser(userExist);
    return "redirect:/home";
  }

  //Mapping for delete user by Id
  @GetMapping("/home/{id}")
  public String deleteUserById(@PathVariable Long id){
    this.service.deleteUser(id);
    return "redirect:/home";
  }



}
