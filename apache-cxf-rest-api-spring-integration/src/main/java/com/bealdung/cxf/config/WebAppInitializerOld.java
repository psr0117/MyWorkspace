package com.bealdung.cxf.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.bealdung.cxf.main.AppConfig;

public class WebAppInitializerOld implements WebApplicationInitializer {

	//https://www.javadevjournal.com/spring/spring-webapplicationinitializer/
//	1. What is Spring WebApplicationInitializer?
//			Spring WebApplicationInitializer is Servlet 3.0 + implementation to configure ServletContext programmatically 
//	in comparison to the traditional way to do this using web.xml.
//			
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		rootContext.setServletContext(servletContext);
		
		// Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));
        
        // Register and map the CTX servlet
        
        CXFServlet cxfServlet = new CXFServlet();
        
        ServletRegistration.Dynamic appServlet = servletContext.addServlet("CXFServlet", cxfServlet);
        
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
        
	}



}
