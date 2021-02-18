package com.santalucia.example.infrastructure.mybatisoracle.config;

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

import com.santalucia.arq.ams.componentes.database.properties.DatasourceConfiguration;

@Configuration
@MapperScan(basePackages = OracleMyBatisConfig.BASE_PACKAGE,
		sqlSessionTemplateRef = OracleMyBatisConfig.SESSION_TEMPLATE)
public class OracleMyBatisConfig {

	private static final String SESSION_FACTORY = "oracleSessionFactory";

	private static final String TRANSACTION_MANAGER = "oracleTransactionManager";

	protected static final String SESSION_TEMPLATE = "oracleSessionTemplate";

	protected static final String BASE_PACKAGE = "com.santalucia.example.infrastructure.mybatisoracle.mappers";

	@Bean(name = SESSION_FACTORY)
	@Primary
	public SqlSessionFactory sqlSessionFactoryBean(
			@Qualifier(DatasourceConfiguration.SECONDARY_DATASOURCE) DataSource dataSource) throws Exception {

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
			@Qualifier(DatasourceConfiguration.SECONDARY_DATASOURCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = SESSION_TEMPLATE)
	@Primary
	public SqlSessionTemplate informixSqlSessionTemplate(
			@Qualifier(SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
