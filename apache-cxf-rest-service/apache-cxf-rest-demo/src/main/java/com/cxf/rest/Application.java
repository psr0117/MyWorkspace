package com.cxf.rest;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class Application {

	public static void main(String[] args) throws Exception {
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
		factoryBean.setResourceClasses(HelloWorld.class);
		factoryBean.setResourceProvider(new SingletonResourceProvider(new HelloWorld()));
		factoryBean.setAddress("http://localhost:8082/");
		Server server = factoryBean.create();
		//server.start();
		System.out.println("Server ready...");
        Thread.sleep(60 * 1000);
        System.out.println("Server exiting");
        server.destroy();
        System.exit(0);
        
	}

}
