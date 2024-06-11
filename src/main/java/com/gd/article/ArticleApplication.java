package com.gd.article;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// servlet : servlet(Controller 가능), filter(Intercepter 가능), listener
@ServletComponentScan
// implements WebMvcConfigurer 를 추가하면 더 제공받을수 있음 
@SpringBootApplication
public class ArticleApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}
	// 추가한 오버라이딩
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 
		registry.addResourceHandler("/img/**").addResourceLocations("file:///c:/upload/");
	}
}
