package com.bealdung.cxf.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bealdung.cxf.repository.PlayersRepository;


@Configuration
@ComponentScan({"com.bealdung"})
public class AppConfig {
	
//	@Bean
//	public PlayersRepository playersRepository() {
//		return new PlayersRepository();
//	}

}
