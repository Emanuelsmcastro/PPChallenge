package com.project.challenge.mstransfer.mstransfer.configs;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

@Configuration
public class GlobalConfig {

	@Bean
	FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter() {
	    FilterRegistrationBean<ForwardedHeaderFilter> bean = new FilterRegistrationBean<>();
	    bean.setFilter(new ForwardedHeaderFilter());
	    return bean;
	}
}
