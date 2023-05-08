package com.example.demo.Configuration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AppConfig {
    @Bean
    public JsonObject jsonObject(){
        return new JsonObject();
    }
    @Bean
    public Gson gson(){return new Gson();}

}
