package com.stone.rest.play.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class AppConfig implements WebMvcConfigurer {

//    @Bean
//    public FilterRegistrationBean<AuthFilter> filterRegistrationBean(AuthFilter authFilter) {
//        FilterRegistrationBean<AuthFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(authFilter);
//        registration.addUrlPatterns("/api/categories/*");
//        return registration;
//    }

}
