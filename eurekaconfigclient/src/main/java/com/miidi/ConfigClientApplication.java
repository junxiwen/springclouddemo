package com.miidi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		//new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
