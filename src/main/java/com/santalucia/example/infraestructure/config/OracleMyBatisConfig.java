package com.santalucia.example.infraestructure.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.santalucia.example.infraestructure.dao.mappers.employees",
		sqlSessionTemplateRef = "oracleSessionTemplate")
public class OracleMyBatisConfig {

	private static final String ORACLE_SESSION_FACTORY = "oracleSessionFactory";

	private static final String ORACLE_TRANSACTION_MANAGER = "oracleTransactionManager";

	private static final String ORACLE_SESSION_TEMPLATE = "oracleSessionTemplate";

	@Bean(name = ORACLE_SESSION_FACTORY)
	@Primary
	public SqlSessionFactory sqlSessionFactoryBean(
			@Qualifier(InfraestructureLayerConfig.ORACLE_DATASOURCE) DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sessionBean = new SqlSessionFactoryBean();
		sessionBean.setDataSource(dataSource);
		return sessionBean.getObject();
	}

	@Bean(name = ORACLE_TRANSACTION_MANAGER)
	@Primary
	public DataSourceTransactionManager informixTransactionManager(
			@Qualifier(InfraestructureLayerConfig.ORACLE_DATASOURCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = ORACLE_SESSION_TEMPLATE)
	@Primary
	public SqlSessionTemplate informixSqlSessionTemplate(
			@Qualifier(ORACLE_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
