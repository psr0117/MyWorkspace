
package jaxws.java.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EmployeeServiceImpl", targetNamespace = "http://service.java.jaxws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeServiceImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns jaxws.java.service.Employee
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEmployeeById", targetNamespace = "http://service.java.jaxws/", className = "jaxws.java.service.GetEmployeeById")
    @ResponseWrapper(localName = "getEmployeeByIdResponse", targetNamespace = "http://service.java.jaxws/", className = "jaxws.java.service.GetEmployeeByIdResponse")
    @Action(input = "http://service.java.jaxws/EmployeeServiceImpl/getEmployeeByIdRequest", output = "http://service.java.jaxws/EmployeeServiceImpl/getEmployeeByIdResponse")
    public Employee getEmployeeById(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}