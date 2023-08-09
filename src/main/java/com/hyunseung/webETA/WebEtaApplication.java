package com.hyunseung.webETA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class WebEtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebEtaApplication.class, args);
	}

}
