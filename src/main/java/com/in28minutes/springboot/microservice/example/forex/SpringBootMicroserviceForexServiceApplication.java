package com.in28minutes.springboot.microservice.example.forex;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableDiscoveryClient*/
public class SpringBootMicroserviceForexServiceApplication {

	@PostConstruct
	public void init()
	{
		// Setting Spring Boot TimeZone
		TimeZone.setDefault( TimeZone.getTimeZone( "IST" ) );
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceForexServiceApplication.class, args);
	}
}
