package com.example.demo.Configuration;

import com.google.gson.Gson;
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
    public Gson gson(){return new Gson();}

}
