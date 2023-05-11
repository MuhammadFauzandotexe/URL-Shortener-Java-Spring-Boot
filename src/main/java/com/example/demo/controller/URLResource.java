package com.example.demo.controller;

import com.example.demo.dto.UrlDTO;
import com.example.demo.model.Author;
import com.example.demo.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class URLResource {
    private final UrlService urlService;
    @GetMapping("/url/{id}")
    public ResponseEntity<Author> addURL(@PathVariable Long id, @RequestBody UrlDTO dto){
        return ResponseEntity.ok(urlService.addNewURL(id,dto));
    }
}
