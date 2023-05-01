package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthorUpdateDTO {
    private String uniqueKey;
    private String username;
    private String email;

}
