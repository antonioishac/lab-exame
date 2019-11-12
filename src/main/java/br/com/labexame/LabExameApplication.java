package br.com.labexame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.labexame.config.property.LabExameApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(LabExameApiProperty.class)
public class LabExameApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabExameApplication.class, args);
	}

}
