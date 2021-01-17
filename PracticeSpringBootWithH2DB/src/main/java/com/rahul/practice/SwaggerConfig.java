package com.rahul.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Rahul Rajput", "http://www.google.com",
			"rahrajput29@gmail.com");
	public static final ApiInfo DEFAULT = new ApiInfo("Awesome API Title", "Api Documentation", "1.0", "urn:tos",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)// new Docket instance
				.select()// select() will give Docket builder insatnce using docket instance
				.apis(RequestHandlerSelectors.basePackage("com.rahul.practice"))// packages to look into it
				// .paths(PathSelectors.regex("/employees/*"))///error will not come in this
				.build().apiInfo(userApiInfo()).produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}

	private ApiInfo userApiInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API").description("User REST API").license("MIT")
				.licenseUrl("https://opensource.org/licenses/MIT").version("0.0.1")
				.termsOfServiceUrl("Term Of Services").build();
	}

}

