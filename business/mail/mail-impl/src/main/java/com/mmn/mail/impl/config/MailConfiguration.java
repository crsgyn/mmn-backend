package com.mmn.mail.impl.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Slf4j
@ComponentScan(basePackages = "com.mmn.mail.impl")
@PropertySource("classpath:mail.properties")
public class MailConfiguration {

    @Value("${spring.mail.username}")
    private String username;
    @Bean
    void logConfig() {
      log.info(username);
    }
}
