package com.jwt.impl.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jwt.impl.Interceptors.JwtInterceptor;

@Configuration
public class JwtWebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private JwtInterceptor JwtInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(JwtInterceptor).addPathPatterns("/jwt/authenticate");
		// registry.addInterceptor(new
		// CollectionInterceptor()).addPathPatterns("/activities");
	}

}
