package com.santalucia.example.infrastructure.mybatis.primary.custom;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.santalucia.example.infrastructure.entity.Cacetrafec;

@Mapper
public interface CacetrafecCustomMapper {

	@Select("select SKIP #{offset} * from cacetrafec where xcacetra = 'I' limit #{limit}")
	public List<Cacetrafec> getIndicadoreswithPagination(@Param("offset") Long offset, @Param("limit") Integer limit);
}
