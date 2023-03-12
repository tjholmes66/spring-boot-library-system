package com.tomholmes.products.library.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.tomholmes.products.library")
@EntityScan("com.tomholmes.products.library.model")
@EnableJpaRepositories(basePackages = "com.tomholmes.products.library.repository")
@EnableTransactionManagement
public class DatabaseConfiguration
{

}
