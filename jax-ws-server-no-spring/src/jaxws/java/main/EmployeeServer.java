package jaxws.java.main;

import javax.xml.ws.Endpoint;

import jaxws.java.service.EmployeeServiceImpl;

public class EmployeeServer {

	public static void main(String[] args) {
		//we need to publish this service to expose this to the external clients
		//we are using inbuild java jax-ws with NO SPRING or other jars
		// test using
		//http://localhost:8080/Sridhar/EmployeeService?wsdl
		//http://localhost:8080/Sridhar/EmployeeService?xsd=1
		
		/*-- Example for this course
		https://www.youtube.com/watch?v=fE1pVSiXNkU&list=PLwIFo6ewnySXtuNQqWLcdnIXvDAlFPazQ&index=4
		--virtualpair programmers site
		*/
		
		// Publish the endpoint and start the service implementation webservice class.
		Endpoint.publish("http://localhost:8080/Sridhar/EmployeeService",
					new EmployeeServiceImpl());
		

	}

}
