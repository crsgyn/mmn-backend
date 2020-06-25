package com.mmn.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableScheduling
public class CoreGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreGatewayApplication.class, args);
	}

	@Scheduled(fixedDelay = 1000 * 60 * 60) // every hour
	public void doNothing() {
		// Forces Spring Scheduling managing thread to start
	}
}
