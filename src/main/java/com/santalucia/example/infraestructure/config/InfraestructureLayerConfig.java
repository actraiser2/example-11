package com.santalucia.example.infraestructure.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import lombok.extern.slf4j.Slf4j;

@Configuration
public class InfraestructureLayerConfig {

	public static final String INFORMIX_DATASOURCE = "informixDS";

	public static final String ORACLE_DATASOURCE = "oracleDS";

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.informix")
	@Primary
	public DataSourceProperties dataSourceInformixProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = INFORMIX_DATASOURCE)
	@ConfigurationProperties(prefix = "spring.datasource.informix.configuration")
	@Primary
	public DataSource dataSourceInformix() {
		return dataSourceInformixProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSourceProperties dataSourceOracleProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = ORACLE_DATASOURCE)
	@ConfigurationProperties(prefix = "spring.datasource.oracle.configuration")
	public DataSource dataSourceOracle() {
		return dataSourceOracleProperties().initializeDataSourceBuilder().build();
	}

}