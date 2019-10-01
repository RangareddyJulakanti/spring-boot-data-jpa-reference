package com.ranga.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by RANGA on 2/21/2017.
 */


@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ranga", "com.ranga.rest"})
@SpringBootApplication
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);
    }
}
