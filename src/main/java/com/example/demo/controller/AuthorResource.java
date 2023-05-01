package com.example.demo.controller;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import com.example.demo.service.AuthorUpdateService;
import com.example.demo.utility.JsonParser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
@AllArgsConstructor
@RestController
public class AuthorResource {
    private final AuthorUpdateService authorUpdateService;
    private final AuthorService authorService;
    private final JsonParser jsonParser;
    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAllDataAuthor(){
        return ResponseEntity.ok(authorService.getAllDataAuthor());
    }
    @PostMapping("/author")
    public ResponseEntity<Author> AuthorPostRequest(@RequestBody AuthorDTO dto) throws NoSuchAlgorithmException, IOException {
        return ResponseEntity.ok(authorService.saveData(dto));
    }
    @GetMapping("/{payload}")
    public String AuthorVerification(@PathVariable String payload) {
        String result = (authorUpdateService.updateByName(payload) > 0) ? "Your account has been verified" : "not found";
        return result;
    }
}
