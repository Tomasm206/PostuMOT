package co.edu.uco.postumot.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.postumot.controller"})
public class PostuMotApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostuMotApplication.class, args);
	}
}
