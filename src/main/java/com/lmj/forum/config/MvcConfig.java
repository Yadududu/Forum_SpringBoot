package com.lmj.forum.config;

import com.lmj.forum.controller.Intercept.UserIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/head").setViewName("head");
        registry.addViewController("/findPassword").setViewName("findPassword");
        registry.addViewController("/detail").setViewName("detail");
        registry.addViewController("/add").setViewName("add");
        registry.addViewController("/404").setViewName("404");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserIntercept()).addPathPatterns("/data/*");
    }
}
