package com.santalucia.example.api.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MultipleDataSourceConfiguration {

	public static final String INFORMIX_DATASOURCE = "informixDS";

	public static final String ORACLE_DATASOURCE = "oracleDS";

	@Bean(name = INFORMIX_DATASOURCE)
	@ConfigurationProperties(prefix = "spring.datasource.informix")
	@Primary
	public DataSource dataSourceInformix() {
		HikariDataSource hikari = new HikariDataSource();

		return hikari;
		// return DataSourceBuilder.create().build();
	}

	@Bean(name = ORACLE_DATASOURCE, destroyMethod = "")
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSource dataSourceOracle() {
		return new HikariDataSource();
		// return DataSourceBuilder.create().build();
	}

}
