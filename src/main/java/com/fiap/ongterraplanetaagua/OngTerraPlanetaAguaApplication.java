package com.fiap.ongterraplanetaagua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OngTerraPlanetaAguaApplication {
	
	@GetMapping("/")
	public String get() {
		return "Bem vindo a rest API";
	}
	
	@GetMapping("/message")
	public String message() {
		return "Bem vindo a rest API";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OngTerraPlanetaAguaApplication.class, args);
	}

}
