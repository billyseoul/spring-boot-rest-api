package com.cloudvendor.rest_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Collections;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {

    SpringApplication.run(RestDemoApplication.class, args);
	}

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI().info(new Info()
            .title("Cloud Vendor REST API")
            .version("1.0")
            .description("REST API documentation for Cloud Vendors")
            .termsOfService("https://github.com/cloudvendor/spring-boot-rest-api")
            .contact(new Contact()
                    .name("John Doe")
                    .email("johndoe@mail.com")
                    .url("https://github.com/cloudvendor/spring-boot-rest-api"))
            .license(new License()
                    .name("My License")
                    .url("https://github.com/cloudvendor/spring-boot-rest-api")));
  }

}
