package com.example.demo.controller;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import com.example.demo.utility.PayLoadEncoder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
@AllArgsConstructor
@RestController
public class AuthorResource {
    private final AuthorService authorService;
    private final PayLoadEncoder payLoadEncoder;
    private final JsonObject jsonObject;
    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAllDataAuthor(){
        return ResponseEntity.ok(authorService.getAllDataAuthor());
    }
    @PostMapping("/author")
    public ResponseEntity<Author> handlePostRequest(@RequestBody AuthorDTO dto) throws NoSuchAlgorithmException, IOException {
        return ResponseEntity.ok(authorService.saveData(dto));
    }
    @GetMapping("/{payload}")
    public String verify(@PathVariable String payload){
        String data = payLoadEncoder.decode(payload);
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode jsonNode = objectMapper.readTree(data);
//            return jsonNode.toString()+"  "+jsonNode.get("name");
//        }
//        catch (Exception e){
//            return e.toString();
//        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        return jsonObject.toString()+"<=========>"+jsonObject.get("name");
    }
}
