package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
    @GetMapping("/")
    public String Index(Model model){
        String URL = "redirect:https://www.youtube.com";
        return URL;
    }
}
