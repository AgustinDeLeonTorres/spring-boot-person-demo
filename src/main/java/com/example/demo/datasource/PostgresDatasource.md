package com.example.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PostgresDatasource {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        // Create HikariDataSource and let @ConfigurationProperties populate it
        return new HikariDataSource();
    }
}