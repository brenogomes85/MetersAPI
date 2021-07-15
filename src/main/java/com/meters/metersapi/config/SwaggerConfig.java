package com.meters.metersapi.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 @Bean
	 public Docket metersApi() {
		 return new Docket(DocumentationType.SWAGGER_2)
				 .select()
				 .apis(RequestHandlerSelectors.basePackage("com.meters.metersapi"))
				 .paths(regex("/portfolio.*"))
				 .build()
				 .apiInfo(metaInfo());
	 }
	 
	 private ApiInfo metaInfo() {
		 ApiInfo apiInfo = new ApiInfo(
				 "Medidores API Rest",
				 "API Rest de medidores",
				 "1.0", "Terms of Service",
				 new Contact("Breno Gomes", "brenogomes124@gmail.com", "https://github.com/brenogomes85/"),
				 "Apache License Version 2.0",
				 "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
				 );
		 return apiInfo;		 
	 }
}
