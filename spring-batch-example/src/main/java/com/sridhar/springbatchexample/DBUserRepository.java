package com.sridhar.springbatchexample;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sridhar.springbatchexample.model.User;

public interface DBUserRepository extends JpaRepository<User, Integer>{

	
	


}
