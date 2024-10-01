package com.example.xlsx.config;

import com.example.xlsx.controller.NthMaxNumberController;
import com.example.xlsx.service.NthMaxNumberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public NthMaxNumberService numberService() {
        return new NthMaxNumberService();
    }
}
