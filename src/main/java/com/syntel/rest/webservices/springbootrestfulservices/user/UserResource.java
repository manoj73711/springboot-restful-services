package com.syntel.rest.webservices.springbootrestfulservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserDaoService service;

	// retrive all users

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();

	}

	// retive User

	@GetMapping(path = "/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
		
		Resource<User> resource=new Resource<>(user);
		
		ControllerLinkBuilder linkTo = 
				ControllerLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);

	}
	
	/*@GetMapping(path= "/hello-world-internalization")
	public String helloWorldInternalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		
		
		return messageSource.getMessage("good.morning.message",null, locale);
	}*/
	
	@GetMapping(path= "/hello-world-internalization")
	public String helloWorldInternalized() {
		
		
		return messageSource.getMessage("good.morning.message",null,
				LocaleContextHolder.getLocale());
	}

}
