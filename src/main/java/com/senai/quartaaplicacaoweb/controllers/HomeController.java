package com.senai.quartaaplicacaoweb.controllers;

import com.senai.quartaaplicacaoweb.services.CookieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping
    public String index(Model model, HttpServletRequest request){
        model.addAttribute("nome", CookieService.getCookie(request, "nome"));
        return "home/index";
    }
}
