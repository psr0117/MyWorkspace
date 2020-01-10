package com.bealdung.cxf.config;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.bealdung.cxf.rest.service.PlayerService;



@Configuration
public class WebServiceContext {
    @Bean
    public SpringBus springBus() {
        System.err.println("\n\n\n\nELI: WebServiceConfig springBus \n\n\n\n");
        return new SpringBus();
    }
    @Bean
    public Endpoint endpoint() {
        System.err.println("\n\n\n\nELI: WebServiceConfig endpoint \n\n\n\n");
        EndpointImpl endpoint = new EndpointImpl(springBus(), new PlayerService());
        //NOT WORK NOT WORK NOT WORK
        //must be a relative path
        //endpoint.publish("http://localhost:8080/web-service-soap-bottom-up-p1/services/ws/ShapeCalculatorWebService");
        //WORKS
        //endpoint.publish("/web-service-soap-bottom-up-p1/services/ws/ShapeCalculatorWebService");
        //WORKS
        //endpoint.publish("/ShapeCalculatorWebService");
        endpoint.publish("ShapeCalculatorWebService");
        return endpoint;
    }
}