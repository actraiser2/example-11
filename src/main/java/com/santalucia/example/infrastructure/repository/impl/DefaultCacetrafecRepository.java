package com.santalucia.example.infrastructure.repository.impl;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

import java.util.List;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecDynamicSqlSupport;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecMapper;
import com.santalucia.example.infrastructure.mybatis.primary.custom.CacetrafecCustomMapper;
import com.santalucia.example.infrastructure.repository.CacetrafecRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DefaultCacetrafecRepository implements CacetrafecRepository {

	private final CacetrafecMapper cacetrafecMapper;
	private final CacetrafecCustomMapper cacetrafecCustomMapper;

	/**
	 * constructor de clase 
	 * @param CacetrafecMapper cacetrafecMapper
	 * @param CacetrafecCustomMapper cacetrafecCustomMapper
	 */
	public DefaultCacetrafecRepository(CacetrafecMapper cacetrafecMapper,
			CacetrafecCustomMapper cacetrafecCustomMapper) {
		this.cacetrafecMapper = cacetrafecMapper;
		this.cacetrafecCustomMapper = cacetrafecCustomMapper;
	}

	/**
	 * recupera los indicadores
	 * @return List<Cacetrafec>
	 */
	@Override
	public List<Cacetrafec> getIndicadores() {
		
	    SelectStatementProvider selectStatement = select(CacetrafecDynamicSqlSupport.cacetrafec.allColumns())
	            .from(CacetrafecDynamicSqlSupport.cacetrafec)
	            .where(CacetrafecDynamicSqlSupport.cacetrafec.xcacetra, isEqualTo("I"))
	            .build()
	            .render(RenderingStrategies.SPRING_NAMED_PARAMETER);
		
		return this.cacetrafecMapper.selectMany(selectStatement);
	}

	/**
	 * recupera los indicadores paginados
	 * @return List<Cacetrafec>
	 */
	@Override
	public List<Cacetrafec> getIndicadores(Pageable pageable) {
		
		log.debug("Inicio consulta Indicadores centros con paginacion");
		return this.cacetrafecCustomMapper.getIndicadoreswithPagination(pageable.getOffset(), pageable.getPageSize());
	}

}
