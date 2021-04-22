package com.lmj.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//使用MapperScan批量扫描所有的Mapper接口；
@MapperScan(value = "com.lmj.forum.dao")
@SpringBootApplication
public class ForumApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ForumApplication.class);
    }
}
