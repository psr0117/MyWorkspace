package com.cxf.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cxf.model.ExampleModel;

@Repository
public class ExampleRepo {

	public ExampleModel getExampleById() {
		return new ExampleModel("example",101);
		
	}

	
}
