package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class Index {
    @GetMapping("/{url}")
    public String Index(@PathVariable("url") String url, Model model){
        return "redirect:https://www.youtube.com/";
    }
}
