package com.senai.quartaaplicacaoweb.controllers;

import com.senai.quartaaplicacaoweb.models.UserModel;
import com.senai.quartaaplicacaoweb.services.CookieService;
import com.senai.quartaaplicacaoweb.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller

public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login")
    public String indexLogin(){
        return "login/login";
    }

    @GetMapping(value="/logout")
    public String logout(HttpServletResponse response){
        CookieService.setCookie(response,"usuarioId","", 0);
        return "redirect:/login";
    }

    @PostMapping(value = "/logar")
    public String logOn(UserModel userModel, Model model, HttpServletResponse response){
        UserModel user = loginService.logar(userModel);

        if(user != null){
            int tempoCookie = 60 * 60 * 8;
            CookieService.setCookie(response,"usuarioId" ,String.valueOf(user.getId()),tempoCookie);
            CookieService.setCookie(response,"nome" ,user.getName(),tempoCookie);
            return "redirect:/";
        } else{
            model.addAttribute("erro","Usuario ou senha invalidos!");
            return "redirect:/login";
        }
    }
}
