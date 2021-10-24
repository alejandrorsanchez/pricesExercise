package com.example.demo;

import com.example.demo.daos.PriceDao;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = {PriceDao.class})
public class JpaConfig {
}
