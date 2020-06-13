package br.com.itau.techinsiders.holmes;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class HolmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolmesApplication.class, args);
	}

	@Bean //https://spring.io/guides/gs/rest-service-cors/
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://127.0.0.1:5500");
            }
        };
	}
	

}
