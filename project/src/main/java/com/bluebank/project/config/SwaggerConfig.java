package com.bluebank.project.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
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
	    @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	          .select()
	          .apis(RequestHandlerSelectors.basePackage("com.bluebank.project.controllers"))
	          .paths(PathSelectors.any())
	          .build()
	          .apiInfo(metaInfo());
	    }
	    

		private ApiInfo metaInfo() {
	    	ApiInfo apiInfo = new ApiInfo(
	    			"BlueBank API",
	    			"API REST controllers",
	    			"(*Trek)",
	    			"Terms of Service",
	    			new Contact("*Trek",
	    					"https://github.com/alanomenezes/BlueBank", 
	    					"ic4ro.p4blo@gmail.com"),
	    					"Star trek is better than Star Wars",
	    					"https://www.cnet.com/pictures/20-reasons-why-star-trek-is-better-than-star-wars-pictures/", new ArrayList<VendorExtension>()
	    					
	    			);
	    	return apiInfo;
	    }
	}
