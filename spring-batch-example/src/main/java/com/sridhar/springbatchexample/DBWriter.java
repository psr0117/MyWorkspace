package com.sridhar.springbatchexample;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sridhar.springbatchexample.model.User;

@Component
public class DBWriter implements ItemWriter<User> {

	@Autowired
	DBUserRepository dbUserRepository;
	
	
	@Override
	public void write(List<? extends User> users) throws Exception {
		
		System.out.println("Saving Users to Database : " + users);
		dbUserRepository.saveAll(users);
		
	}

}
