package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import Morpion.Game;

@SpringBootApplication
@ComponentScan(basePackages = { "controllers", "sudoku", "services" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Game game = new Game();

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/sudoku/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/morpion/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/pfc/*").allowedOrigins("http://localhost:4200");
			}

		};

	}
}
