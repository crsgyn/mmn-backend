package com.mmn.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableEurekaServer
@EnableScheduling
public class CoreRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreRegistryApplication.class, args);
	}

	@Scheduled(fixedDelay = 1000 * 60 * 60) // every hour
	public void doNothing() {
		// Forces Spring Scheduling managing thread to start
	}
}
