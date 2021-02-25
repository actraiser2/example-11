package com.santalucia.example.infrastructure.repository.impl;

import java.util.List;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecDynamicSqlSupport;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecMapper;
import com.santalucia.example.infrastructure.repository.CacetrafecRepository;

@Repository
public class DefaultCacetrafecRepository implements CacetrafecRepository {

	private final CacetrafecMapper cacetrafecMapper;

	public DefaultCacetrafecRepository(CacetrafecMapper cacetrafecMapper) {
		this.cacetrafecMapper = cacetrafecMapper;
	}

	@Override
	public List<Cacetrafec> getAgencias() {
		
	    SelectStatementProvider selectStatement = select(CacetrafecDynamicSqlSupport.cacetrafec.allColumns())
	            .from(CacetrafecDynamicSqlSupport.cacetrafec)
	            .where(CacetrafecDynamicSqlSupport.cacetrafec.xcacetra, isEqualTo("1"))
	            .build()
	            .render(RenderingStrategies.MYBATIS3);
		
		return this.cacetrafecMapper.selectMany(selectStatement);
	}

}
