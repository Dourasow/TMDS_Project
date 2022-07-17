package com.wisdomtech.tmds;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping(value = {"/layout"})
    public String layout(){
        return "layout";
    }

    @GetMapping("/garage")
    public String garage() {
        return "/garage/garage_index";
    }

}
