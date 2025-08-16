package com.santalucia.example.infrastructure.shell;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.santalucia.arq.ams.data.jdbc.qualifiers.AmsJdbcTemplate;
import com.santalucia.arq.ams.data.jdbc.qualifiers.AmsJdbcTemplate.JdbcTemplateType;

import lombok.extern.slf4j.Slf4j;

@ShellComponent
@Slf4j
public class Example11Shell {

	@Autowired @AmsJdbcTemplate(jdbcTemplateType = JdbcTemplateType.PRIMARY) NamedParameterJdbcOperations jdbcTemplate;
	
	@ShellMethod(value = "Count all entries table Cacetrafec", key = "countCacetrafec") 
	public void countCacetrafec() {
		log.info("Invoked counbtCacetrafec: {}", jdbcTemplate);
		
		List<Integer> numElements = jdbcTemplate.queryForList("select count(*) from cacetrafec", Map.of(), Integer.class);
		
		
		log.info("numElements: {}", numElements.get(0));
	
	}
	
	@ShellMethod(value = "Query all entries table Cacetrafec", key="queryCacetrafec")
	public void queryCacetrafec() {
		log.info("Invoked queryCacetrafec: {}", jdbcTemplate);
		
		List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from cacetrafec", Map.of());
		
		log.info(result.toString());
	}
}
