package com.bealdung.cxf.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bealdung.cxf.repository.PlayersRepository;
import com.bealdung.cxf.rest.service.PlayerService;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
@ComponentScan({"com.bealdung"})
public class Application {

	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//appContext
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
		List<Object> providers = new ArrayList<Object>();
		providers.add(new JacksonJsonProvider());
		providers.add(new com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider());
		
		factoryBean.setProviders(providers);
		
		
		factoryBean.setServiceBean(new PlayerService());
		//factoryBean.setServiceBean(new PlayersRepository());
		factoryBean.setBus(new SpringBus());
		
		factoryBean.setResourceClasses(PlayerService.class);
		factoryBean.setResourceProvider(new SingletonResourceProvider(new PlayerService(appContext)));
		//factoryBean.setResourceProvider(new SingletonResourceProvider(new PlayerService(appContext.getBean("PlayersRepository", PlayersRepository.class))));
		
		factoryBean.setAddress("http://localhost:8083/");
		
		
		
		
		Server server = factoryBean.create();
		//server.start();
		System.out.println("Server ready...");
        Thread.sleep(60 * 1000);
        System.out.println("Server exiting");
        server.destroy();
        System.exit(0);

	}

}
