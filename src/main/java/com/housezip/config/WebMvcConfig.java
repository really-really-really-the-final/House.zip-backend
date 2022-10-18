package com.housezip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.housezip.interceptor.JwtInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
    
	@Autowired
	private JwtInterceptor interceptor;
	
    public void addInterceptors(InterceptorRegistry registry) {
    
        registry.addInterceptor(interceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns(
                		"/userregist",
                		"/swagger-resources/**",
                		"/swagger-ui/**",
                		"/**/house/list/**",
                		"v2/api-docs"
                		);
    }

}