package com.sridhar.springbatchexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sridhar.springbatchexample.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
