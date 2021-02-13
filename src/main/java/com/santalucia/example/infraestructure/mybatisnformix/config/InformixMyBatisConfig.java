package com.santalucia.example.infraestructure.mybatisnformix.config;

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

import com.santalucia.example.infraestructure.config.InfraestructureLayerConfig;

@Configuration
@MapperScan(basePackages = "com.santalucia.example.infraestructure.mybatisnformix.mappers",
		sqlSessionTemplateRef = InformixMyBatisConfig.SESSION_TEMPLATE)
public class InformixMyBatisConfig {

	private static final String SESSION_FACTORY = "informixSessionFactory";

	private static final String TRANSACTION_MANAGER = "informixTransactionManager";

	protected static final String SESSION_TEMPLATE = "informixSessionTemplate";

	@Bean(name = SESSION_FACTORY)
	@Primary
	public SqlSessionFactory sqlSessionFactoryBean(
			@Qualifier(InfraestructureLayerConfig.INFORMIX_DATASOURCE) DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sessionBean = new SqlSessionFactoryBean();
		sessionBean.setDataSource(dataSource);
		return sessionBean.getObject();
	}

	@Bean(name = TRANSACTION_MANAGER)
	@Primary
	public DataSourceTransactionManager informixTransactionManager(
			@Qualifier(InfraestructureLayerConfig.INFORMIX_DATASOURCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = SESSION_TEMPLATE)
	@Primary
	public SqlSessionTemplate informixSqlSessionTemplate(
			@Qualifier(SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
