package com.example.demo.Configuration;

import com.example.demo.service.AuthorUpdateService;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@AllArgsConstructor
public class AppConfig {
    private final EntityManager entityManager;
    @Bean
    public JsonObject jsonObject(){
        return new JsonObject();
    }
    @Bean
    AuthorUpdateService authorUpdateService(){return new AuthorUpdateService(entityManager);}
}
