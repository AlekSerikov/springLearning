package org.example.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:spring.properties")
@ComponentScan("org.example.spring")
public class MyConfig {



}
