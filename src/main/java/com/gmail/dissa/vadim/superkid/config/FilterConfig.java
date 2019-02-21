package com.gmail.dissa.vadim.superkid.config;

import com.gmail.dissa.vadim.superkid.filter.RedirectFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<RedirectFilter> someFilterRegistration() {
        FilterRegistrationBean<RedirectFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RedirectFilter());
        registration.addUrlPatterns("/login/");
        registration.setName("loginFilter");
        registration.setOrder(1);
        return registration;
    }
}
