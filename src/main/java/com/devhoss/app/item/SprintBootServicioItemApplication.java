package com.devhoss.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class SprintBootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootServicioItemApplication.class, args);
	}

}
