package com.safaricom.backendApi.apiDocConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {
 
	@Bean
	
	public OpenAPI openAPI() {
		
		return new OpenAPI().info(new Info().title("Safaricom Blog Api ").version("1.0").description("safaricom api doc") );
	}
	
  
}
