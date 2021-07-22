package com.arcesi.arcesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArcesiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArcesiApplication.class, args);
	}
}

@RestController
class HelloController {
	
	String hello() {
		return "Salut tout le monde !!!";
	}
}