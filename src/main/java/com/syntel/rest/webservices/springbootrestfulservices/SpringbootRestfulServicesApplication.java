package com.syntel.rest.webservices.springbootrestfulservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringbootRestfulServicesApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulServicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver() {
		//SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	
	//This below code can be written in application.properties
	/*@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}*/
	
	
}
