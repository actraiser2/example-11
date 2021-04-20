package com.santalucia.example.infrastructure.repository.impl;

import java.math.BigDecimal;
import java.util.List;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.github.pagehelper.PageHelper;
import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecDynamicSqlSupport;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecMapper;
import com.santalucia.example.infrastructure.repository.CacetrafecRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	            .where(CacetrafecDynamicSqlSupport.cacetrafec.xcacetra, isEqualTo("I"))
	            .build()
	            .render(RenderingStrategies.MYBATIS3);
		
		return this.cacetrafecMapper.selectMany(selectStatement);
	}

	@Override
	public List<Cacetrafec> getAgencias(Pageable pageable) {
		
		log.info("Pageable pagenumber: {} ", pageable.getPageNumber());
		log.info("Pageable pageSize: {} ", pageable.getPageSize());
		log.info("Pageable offset: {} ", pageable.getOffset());
		
		int offset = new BigDecimal(pageable.getOffset()).intValue();
		
		PageHelper.startPage(offset, pageable.getPageSize());
		
		SelectStatementProvider selectStatement = select(CacetrafecDynamicSqlSupport.cacetrafec.allColumns())
	            .from(CacetrafecDynamicSqlSupport.cacetrafec)
	            .where(CacetrafecDynamicSqlSupport.cacetrafec.xcacetra, isEqualTo("I"))
	            .build()
	            .render(RenderingStrategies.MYBATIS3);
		
		List<Cacetrafec> listEntity = this.cacetrafecMapper.selectMany(selectStatement);
		return listEntity;
	}

}
