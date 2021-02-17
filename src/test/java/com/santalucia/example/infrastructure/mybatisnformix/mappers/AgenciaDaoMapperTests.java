package com.santalucia.example.infrastructure.mybatisnformix.mappers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.jdbc.SqlMergeMode.MergeMode;

import com.santalucia.example.core.domain.AgenciaDomain;

@Disabled("for demonstration purposes")
@MybatisTest
@SqlMergeMode(MergeMode.MERGE)
@Sql(scripts = { "/sql/schemas/agencia-schema.sql" })
class AgenciaDaoMapperTests {

	@Autowired
	private AgenciaDaoMapper agenciaDaoMapper;

	@Test
	@Sql(scripts = { "/sql/data/agencia-data.sql" })
	void getAgenciasTest() {
		List<AgenciaDomain> city = agenciaDaoMapper.getAgencias();
		assertNotNull(city);
		// assertList(city.getState()).isEqualTo("CA");
		// assertThat(city.getCountry()).isEqualTo("US");
	}

}