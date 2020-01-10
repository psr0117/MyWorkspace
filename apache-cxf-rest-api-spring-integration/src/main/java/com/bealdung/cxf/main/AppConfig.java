package com.bealdung.cxf.main;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.service.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bealdung.cxf.repository.PlayersRepository;
import com.bealdung.cxf.rest.service.IPlayerService;
import com.bealdung.cxf.rest.service.PlayerService;
import javax.xml.namespace.QName;

@Configuration
@ComponentScan({"com.bealdung"})
public class AppConfig {
	
	@Bean
	public SpringBus springBus() {
	    return new SpringBus();
	}
	
	@Bean
	public Endpoint endpoint() {
	    EndpointImpl endpointimpl = new EndpointImpl(springBus(), (Service) new PlayerService(), (QName)null);
	    endpointimpl
	    ((Object) endpointimpl).publish("http://localhost:8083/services/baeldung");
	    return endpointimpl;
	}
	

}
