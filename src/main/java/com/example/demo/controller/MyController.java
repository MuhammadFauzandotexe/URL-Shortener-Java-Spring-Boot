package com.example.demo.controller;

import com.example.demo.service.RedirectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MyController {
    private RedirectService redirectService;
    @GetMapping("/{url}")
    public String redirectToPage(@PathVariable("url") String url, Model modell) {
        return redirectService.getUrl(url);
    }
}
