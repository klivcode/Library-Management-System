package com.librarymanagementsystem.librarymanagementsystem.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper ModelMapper() { return new ModelMapper(); }
}
