package com.example.demo.controller;

import com.example.demo.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
@AllArgsConstructor
public class RedirectRoute {
    private UrlService urlService;
    @GetMapping("/{url}")
    public String redirectToPage(@PathVariable("url") String url, Model modell) {
        return urlService.getUrl(url);
    }
}
