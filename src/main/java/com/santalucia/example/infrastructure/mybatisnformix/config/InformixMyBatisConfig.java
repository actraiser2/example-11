package com.santalucia.example.infrastructure.mybatisnformix.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.santalucia.example.infrastructure.config.InfrastructureLayerConfig;

@Configuration
@MapperScan(basePackages = InformixMyBatisConfig.BASE_PACKAGE,
		sqlSessionTemplateRef = InformixMyBatisConfig.SESSION_TEMPLATE)
public class InformixMyBatisConfig {

	private static final String SESSION_FACTORY = "informixSessionFactory";

	private static final String TRANSACTION_MANAGER = "informixTransactionManager";

	protected static final String SESSION_TEMPLATE = "informixSessionTemplate";

	protected static final String BASE_PACKAGE = "com.santalucia.example.infrastructure.mybatisnformix.mappers";

	@Bean(name = SESSION_FACTORY)
	@Primary
	public SqlSessionFactory sqlSessionFactoryBean(
			@Qualifier(InfrastructureLayerConfig.INFORMIX_DATASOURCE) DataSource dataSource) throws Exception {

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setVfs(SpringBootVFS.class);
		// sessionBean.setMapperLocations(InformixMyBatisConfig.BASE_PACKAGE);
		// sessionBean.setDatabaseIdProvider(DatabaseIdProvider.);
		return factoryBean.getObject();
	}

	@Bean(name = TRANSACTION_MANAGER)
	@Primary
	public DataSourceTransactionManager informixTransactionManager(
			@Qualifier(InfrastructureLayerConfig.INFORMIX_DATASOURCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = SESSION_TEMPLATE)
	@Primary
	public SqlSessionTemplate informixSqlSessionTemplate(
			@Qualifier(SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
