package com.santalucia.example.api.config;

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
@MapperScan(basePackages = "com.santalucia.example.infraestructure.dao.mappers.agencias",
		sqlSessionTemplateRef = "informixSessionTemplate")
public class InformixMyBatisConfig {

	private static final String INFORMIX_SESSION_FACTORY = "informixSessionFactory";

	private static final String INFORMIX_TRANSACTION_MANAGER = "informixTransactionManager";

	private static final String INFORMIX_SESSION_TEMPLATE = "informixSessionTemplate";

	@Bean(name = INFORMIX_SESSION_FACTORY)
	@Primary
	public SqlSessionFactory sqlSessionFactoryBean(
			@Qualifier(MultipleDataSourceConfiguration.INFORMIX_DATASOURCE) DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sessionBean = new SqlSessionFactoryBean();
		sessionBean.setDataSource(dataSource);
		return sessionBean.getObject();
	}

	@Bean(name = INFORMIX_TRANSACTION_MANAGER)
	@Primary
	public DataSourceTransactionManager informixTransactionManager(
			@Qualifier(MultipleDataSourceConfiguration.INFORMIX_DATASOURCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = INFORMIX_SESSION_TEMPLATE)
	@Primary
	public SqlSessionTemplate InformixSqlSessionTemplate(
			@Qualifier(INFORMIX_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
