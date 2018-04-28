package com.syntel.rest.webservices.springbootrestfulservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	@GetMapping(path="/filtering")
	public MappingJacksonValue getSomeBean() {
		
		SomeBean someBean = new SomeBean("WalterWhite", "account_num_12345566", "pAssword");
		
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping(path="/filtering-list")
	public MappingJacksonValue getListOfSomeBeans(){
				
				List<SomeBean> someBeanList=Arrays.asList(
				new SomeBean("Mike", "account_num_12345563", "passWord123"),
				new SomeBean("Jessi","account_num_678391","PASSworD23"));
		
				SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
				
				FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
				
				MappingJacksonValue mapping=new MappingJacksonValue(someBeanList);
				mapping.setFilters(filters);
				
				return mapping;

	}
}
