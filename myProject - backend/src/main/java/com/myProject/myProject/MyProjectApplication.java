package com.myProject.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@ComponentScan(basePackages = {"com.myProject.myProject"})
@EntityScan(basePackages = "com.myProject.myProject")
@EnableJpaRepositories ("com.myProject.myProject.repository") 
@SpringBootApplication
public class MyProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

}
