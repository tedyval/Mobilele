package com.example.mobilele.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
  public ModelMapper  mapper(){
      return new ModelMapper();
  }

  @Bean
  public PasswordEncoder encoder(){
        return new Pbkdf2PasswordEncoder();
  }
}
