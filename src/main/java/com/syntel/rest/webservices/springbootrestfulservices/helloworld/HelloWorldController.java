package com.syntel.rest.webservices.springbootrestfulservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		
		return "Hello world";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("hello world bean");
	}
	
	@GetMapping(path="/hello-world-bean/pathvaiable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello world,  %s", name));
		
	}
}
