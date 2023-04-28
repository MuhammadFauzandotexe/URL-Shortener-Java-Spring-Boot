package com.example.demo.Configuration;

import com.google.gson.JsonObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public JsonObject jsonObject(){
        return new JsonObject();
    }
}
