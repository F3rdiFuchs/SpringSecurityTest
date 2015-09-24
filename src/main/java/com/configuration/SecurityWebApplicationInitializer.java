package com.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}

/*
* Automatically register the springSecurityFilterChain Filter for every URL in your application
* Add a ContextLoaderListener that loads the SecurityConfig.
*/