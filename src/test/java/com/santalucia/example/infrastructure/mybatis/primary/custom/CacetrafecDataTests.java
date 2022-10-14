package com.santalucia.example.infrastructure.mybatis.primary.custom;

import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.mybatis.primary.CacetrafecDynamicSqlSupport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;


@DataJdbcTest
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
@AutoConfigureMybatis
@Sql(scripts = { "/sql/schemas/cacetrafec-schema.sql" })
class CacetrafecDataTests {

  @Autowired
  private CacetrafecCustomMapper cacetrafecCustomMapper;

  @Test
  @Sql(scripts = { "/sql/data/cacetrafec-data.sql" })
  @DisplayName("Test asegurando que se retorna un resultado")
  void getAgenciasTestDataJDBC() {

    SelectStatementProvider selectStatement = select(CacetrafecDynamicSqlSupport.cacetrafec.allColumns())
      .from(CacetrafecDynamicSqlSupport.cacetrafec)
      .where(CacetrafecDynamicSqlSupport.cacetrafec.xcacetra, isEqualTo("1"))
      .build()
      .render(RenderingStrategies.MYBATIS3);

    List<Cacetrafec> city = cacetrafecCustomMapper.selectMany(selectStatement);

    assertThat(city)
      .isNotNull();

    assertThat(city.size())
      .isEqualTo(1);

  }
}
