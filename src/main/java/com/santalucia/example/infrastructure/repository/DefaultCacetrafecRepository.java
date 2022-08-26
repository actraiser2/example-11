package com.santalucia.example.infrastructure.repository;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

import java.util.List;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecDynamicSqlSupport;
import com.santalucia.example.infrastructure.mybatis.primary.custom.CacetrafecCustomMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@AllArgsConstructor
public class DefaultCacetrafecRepository implements CacetrafecRepository {
	
	private final CacetrafecCustomMapper cacetrafecCustomMapper;

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

		return this.cacetrafecCustomMapper.selectMany(selectStatement);
	}

	/**
	 * recupera los indicadores paginados
	 * @param Pageable pageable
	 * @return List<Cacetrafec>
	 */
	@Override
	public List<Cacetrafec> getIndicadores(Pageable pageable) {

		log.debug("Inicio consulta Indicadores centros con paginacion");
		return this.cacetrafecCustomMapper.getIndicadoreswithPagination(pageable.getOffset(), pageable.getPageSize());
	}

}
