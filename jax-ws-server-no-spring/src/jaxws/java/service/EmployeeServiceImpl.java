package jaxws.java.service;

import javax.jws.WebService;

import jaxws.java.domain.Employee;


//TO convert this service into webservice, use the inbuilt java jax-ws webservice annotation
@WebService
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee getEmployeeById(String employeeId) {
		return new Employee("1","Charles Dickson");
	}

}
