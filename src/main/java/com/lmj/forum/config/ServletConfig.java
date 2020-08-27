package com.lmj.forum.config;

import com.lmj.forum.filter.IndexFilter;
import com.lmj.forum.listener.SessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class ServletConfig {

//    @Bean
//    public ServletRegistrationBean myServlet(){
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new IndexFilter(),"/myServlet");
//        registrationBean.setLoadOnStartup(1);
//        return registrationBean;
//    }

    @Bean
    public FilterRegistrationBean myFilter(IndexFilter filter){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
        registrationBean.setUrlPatterns(Arrays.asList("/index","/"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<SessionListener> registrationBean = new ServletListenerRegistrationBean<>(new SessionListener());
        return registrationBean;
    }
}
