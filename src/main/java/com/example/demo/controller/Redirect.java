package com.example.demo.controller;

import com.example.demo.service.RedirectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class Redirect {
    private RedirectService redirectService;
    @GetMapping("xxxx/{url}")
    public String Index(@PathVariable("url") String url, Model model){
        return "redirect:www.youtube.com";
    }



//    public RedirectView Index(@PathVariable("url") String url){
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl(redirectService.getUrl(url).toString());
//        return redirectView;
//    }
}
