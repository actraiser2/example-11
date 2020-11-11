package com.santalucia.example.infraestructure.dao.mappers.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.infraestructure.dao.mappers.agencias.AgenciaMapper;

@ExtendWith(SpringExtension.class)
@MybatisTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AgenciaMappersTest {

	@Autowired
	private AgenciaMapper agenciaMapper;

	@Test
	public void getAgenciasTest() {
		List<AgenciaDomain> listAgencias = agenciaMapper.getAgencias();

		assertNotNull(listAgencias);

		AgenciaDomain agencia1 = listAgencias.get(0);

		System.out.println("Agencia: " + agencia1.getDagencia());
	}

}
