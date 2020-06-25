package com.mmn.account;

import com.mmn.mail.impl.config.MailConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.mmn.account.client")
@EnableCircuitBreaker
@Import(MailConfiguration.class)
@EnableScheduling
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60) // every hour
    public void doNothing() {
        // Forces Spring Scheduling managing thread to start
    }
}
