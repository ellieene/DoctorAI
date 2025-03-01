package com.example.doctorai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.example.doctorai")
@EnableScheduling
@EnableFeignClients
public class DoctorAiNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorAiNewsApplication.class, args);
	}

}
