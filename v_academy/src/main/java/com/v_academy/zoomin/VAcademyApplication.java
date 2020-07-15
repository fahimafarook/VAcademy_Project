package com.v_academy.zoomin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.v_academy.zoomin.model")
@EnableJpaRepositories("com.v_academy.zoomin.repository")
public class VAcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(VAcademyApplication.class, args);
	}

}
