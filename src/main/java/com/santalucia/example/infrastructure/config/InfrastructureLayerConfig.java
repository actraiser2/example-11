package com.santalucia.example.infrastructure.config;

import java.sql.SQLException;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
public class InfrastructureLayerConfig {

	// https://docs.spring.io/spring-boot/docs/2.1.18.RELEASE/reference/html/howto-data-access.html#howto-two-datasources

	public static final String INFORMIX_DATASOURCE = "informixDS";

	public static final String ORACLE_DATASOURCE = "oracleDS";

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.informix")
	@Primary
	public DataSourceProperties dataSourceInformixProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSourceProperties dataSourceOracleProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = INFORMIX_DATASOURCE)
	@ConfigurationProperties(prefix = "spring.datasource.informix.configuration")
	@Primary
	public HikariDataSource dataSourceInformix() throws SQLException {

		HikariDataSource ds = dataSourceInformixProperties().initializeDataSourceBuilder().type(HikariDataSource.class)
				.build();
		// HikariDataSource ds =
		// dataSourceInformixProperties().initializeDataSourceBuilder().type(HikariDataSource.class)
		// .build();
		// force get connection due to lazy initialization introudced in SB 2.22
		// https://github.com/spring-projects/spring-boot/issues/19596
		ds.getConnection();
		log.warn("Informix Pool Name " + ds.getPoolName());
		return ds;
	}

	@Bean(name = ORACLE_DATASOURCE)
	@ConfigurationProperties(prefix = "spring.datasource.oracle.configuration")
	public HikariDataSource dataSourceOracle() throws SQLException {

		HikariDataSource ds = dataSourceOracleProperties().initializeDataSourceBuilder().type(HikariDataSource.class)
				.build();
		// force get connection due to lazy initialization introudced in SB 2.22
		// https://github.com/spring-projects/spring-boot/issues/19596
		ds.getConnection();
		log.warn("Oracle Pool Name " + ds.getPoolName());
		return ds;
	}

}