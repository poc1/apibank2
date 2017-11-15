/**
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.developers.msa.ola;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
    
    @Bean
	   public Docket newsApi() {
	       return new Docket(DocumentationType.SWAGGER_2)
	               .select()
             .apis(RequestHandlerSelectors.any())
             //.apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
             .paths(regex("/customer/.*"))
             .build()
         .pathMapping("/")
         .apiInfo(apiInfo());


	               
	   }

	   
	   private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	            .title("Microservicio de API DEMO BANK Clientes")
	            .description("Consultar operaciones al API del Banco Demo Clientes")
//	            .contact(new Contact("AN Global", "",/*"http://developers.redhat.com"*/ "paul.montoya@agsnasoft.com"))
//	            .license("Apache License Version 2.0")
//	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
	    }

}
