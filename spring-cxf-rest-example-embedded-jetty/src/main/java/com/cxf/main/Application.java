package com.cxf.main;

import com.cxf.main.JettyServerImpl;

public class Application {

	// Test http://localhost:8083/spring-cxf-rest-example-embedded-jetty/services/example/1
	public static void main(String[] args) throws Exception {
		new JettyServerImpl().Start();
		
	}

}
