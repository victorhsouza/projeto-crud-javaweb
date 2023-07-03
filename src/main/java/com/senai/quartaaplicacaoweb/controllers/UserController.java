package com.senai.quartaaplicacaoweb.controllers;

import com.senai.quartaaplicacaoweb.models.UserModel;
import com.senai.quartaaplicacaoweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        List<UserModel> listUser = userService.findAll();
        model.addAttribute("users",listUser);
        return "user/users";
    }

    @GetMapping(value = "/registro")
    public String formInsertUser(){
        return "user/register";
    }


    @PostMapping(value = "/cadastrar")
    public String saveUser(UserModel userModel){
        userService.save(userModel);
        return "redirect:/usuarios";
    }


}
