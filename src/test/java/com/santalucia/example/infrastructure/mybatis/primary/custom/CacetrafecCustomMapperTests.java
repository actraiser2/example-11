package com.santalucia.example.infrastructure.mybatis.primary.custom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

import java.util.List;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.jdbc.SqlMergeMode.MergeMode;

import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecDynamicSqlSupport;

//@Disabled("for demonstration purposes")
@MybatisTest
@SqlMergeMode(MergeMode.MERGE)
@Sql(scripts = {"/sql/schemas/cacetrafec-schema.sql"})
class CacetrafecCustomMapperTests {

	@Autowired
	private CacetrafecCustomMapper cacetrafecCustomMapper;

	@Test
	@Sql(scripts = { "/sql/data/cacetrafec-data.sql" })
	@DisplayName("Dada una query a cacetrafec por xcacetra = 1 se retorna un resultado")
	void getAgenciasTest() {

	    SelectStatementProvider selectStatement = select(CacetrafecDynamicSqlSupport.cacetrafec.allColumns())
	            .from(CacetrafecDynamicSqlSupport.cacetrafec)
	            .where(CacetrafecDynamicSqlSupport.cacetrafec.xcacetra, isEqualTo("1"))
	            .build()
	            .render(RenderingStrategies.MYBATIS3);

		List<Cacetrafec> city = cacetrafecCustomMapper.selectMany(selectStatement);
		assertThat(city).isNotNull();
	}

}
