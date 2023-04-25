package com.example.demo.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class ConfigDTO {
    @Value("${domain}")
    public String domain;
}
