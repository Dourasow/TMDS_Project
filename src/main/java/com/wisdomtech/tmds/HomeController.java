package com.wisdomtech.tmds;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index", "/home"})
    public String home(){
        return "index";
    }

    @GetMapping(value = {"/login", "/sign-in"})
    public String login(){
        return "login";
    }

    @GetMapping(value = {"/register", "/sign-up"})
    public String register(){
        return "register";
    }
    
}
