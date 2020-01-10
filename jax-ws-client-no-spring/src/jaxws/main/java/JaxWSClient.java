package jaxws.main.java;

import jaxws.java.service.Employee;
import jaxws.java.service.EmployeeServiceImpl;
import jaxws.java.service.EmployeeServiceImplService;

public class JaxWSClient {

	public static void main(String[] args) {
		//https://www.youtube.com/watch?v=fE1pVSiXNkU&list=PLwIFo6ewnySXtuNQqWLcdnIXvDAlFPazQ&index=4
		
		//Lets generate the wsdl implementation classes using java wsimport tool
		//that takes the WSDL and generates the java classes from it.
		// the tool is now configured as External Tools program by me
		//After the program is run, it creates the files inside jaxws.java.service package automatically

		EmployeeServiceImpl empClient = new EmployeeServiceImplService().getEmployeeServiceImplPort();
		Employee emp = empClient.getEmployeeById("1");
		System.out.println("Employee Name: " + emp.getName());
		
	}

}
