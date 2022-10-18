package com.housezip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("House.zip API")
				.description("<h3>House.zip 프로젝트에서 사용되는 RestApi에 대한 문서를 제공한다.</h3>")
				.license("MIT License")
				.version("7.0").build();

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.housezip.controller"))
				.paths(PathSelectors.ant("/**/user/**").or(PathSelectors.ant("/**/house/**")).or(PathSelectors.ant("/**/notice/**")).or(PathSelectors.ant("/**/qna/**")))
				.build();
	}
}
