package com.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.configuration.SecurityConfig;
import com.configuration.SpringWebConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}

/*

DisptacherServlet

DispatcherServlet is the front controller in Spring MVC.   It is a HttpServlet that will receive
 the request and return the response.  DispatcherServlet is the key player in SpringMVC.  From the
  below brief work flow of SpringMVC you can see DispatcherServlet is the driving force that make the 
  request served with the right response sent back to the client.    
  
    Receive the request from client
    Consult HandleMapping to decide which controller processes the request
    Dispatch the request to the controller   
    Controller processes the request and returns the logical view name and model back to DispatcherServlet
    Consult ViewResolver for appropriate View for the logical view name from Controller
    Pass the model to View implementation for rendering
    View renders the model and returns the result to DispatcherServlet
    Return the rendered result from view to the client

It is obvious that DispatcherServlet has a heavy workload.  It needs many other strategy objects and configuration
 to perform these work.   Each DispatcherServlet has its own specialized ApplicationContext: WebApplicationContext.


MappingHandler

One important work to be done before DispatcherServlet can dispatch the request to the Controller is to find out which
 controller is right one for this request.  DispatcherServlet uses MappingHandler strategy object to do so. 
   There are many MappingHandler implementations which uses different strategies to map the request to Controller. 
     By default DispatcherServlet will use BeanNameUrlHandlerMapping and DefaultAnnotationHandlerMapping.
  *
  */