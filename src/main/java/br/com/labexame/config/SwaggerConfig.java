package br.com.labexame.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() {
    	return new Docket(DocumentationType.SWAGGER_2)
    	        .select()
    	        .paths(PathSelectors.any())
    	        .apis(Predicates.or(RequestHandlerSelectors
    	            .basePackage("br.com.labexame.resource"),
    	            RequestHandlerSelectors
    	                .basePackage("br.com.labexame.resource")))
    	        .build().directModelSubstitute(LocalDate.class, String.class)
    	        .genericModelSubstitutes(ResponseEntity.class)
    	        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API para manuten\u00e7\u00e3o de laborat\u00f3rios e exames").description("")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .contact(new Contact("Antônio Ishac", "Telefone: (11) 97178-8887", "e-mail: antonioishac@gmail.com"))
                .license("Open Source").licenseUrl("API - Case Técnico").version("1.0.0").build();
    }
}