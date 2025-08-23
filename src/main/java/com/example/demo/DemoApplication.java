package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
public class DemoApplication implements CommandLineRunner {

	private final JdbcTemplate jdbcTemplate;

	public DemoApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			System.out.println("🚀 Starting database connection test...");
			String result = jdbcTemplate.queryForObject("SELECT version()", String.class);
			System.out.println("✅ SUCCESS! Database connection working: " + result);
		} catch (Exception e) {
			System.out.println("❌ FAILED! Database connection error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}