package com.cxf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.model.ExampleModel;
import com.cxf.repository.ExampleRepo;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

//	https://idodevjobs.wordpress.com/2014/08/30/develop-a-simple-restful-webservices-using-apache-cxf-and-spring-framework/
		
	//http://localhost:8080/spring-cxf-rest-example/services/example/1
	
	@Autowired
	ExampleRepo exampleRepo;
	
	public ExampleModel get(String id) {
		return exampleRepo.getExampleById();
	}

}
