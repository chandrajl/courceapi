package com.javalearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(new DocumentationType("Product Api", "2.0"))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.javalearn.controller"))
				.paths(regex("/product.*"))
				.build()
				.apiInfo(metaData());
	}
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot REST API",
				"Spring Boot REST API for Online Store",
				"1.0",
				"Terms of service",
				new Contact("Chandra", "http://myjavaguidence.blogspot.com/", "chandrareddy.mcsr@gmail.com"),
				"Apache License Version 1.0",
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}
