package com.ibm.restaurant.infrastructure;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.ibm.restaurant")
@EntityScan(basePackages = "com.ibm.restaurant")
@ComponentScan(basePackages = "com.ibm.restaurant")
@EnableAutoConfiguration
public class PersistenceConfig {
}