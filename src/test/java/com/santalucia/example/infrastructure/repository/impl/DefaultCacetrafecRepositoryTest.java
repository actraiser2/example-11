package com.santalucia.example.infrastructure.repository.impl;

import com.santalucia.example.infrastructure.mybatis.primary.custom.CacetrafecCustomMapper;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class DefaultCacetrafecRepositoryTest {

  @InjectMocks
  DefaultCacetrafecRepository defaultCacetrafecRepository;

  @Mock
  CacetrafecCustomMapper cacetrafecCustomMapper;

  @Test
  @DisplayName("Probamos que se cargan todos los indicadores cuando no se aplican filtros")
  void givenNoFilterParameters_whenSelectAllIndicadores_thenReturnAllIndicadores() {
    //given
    defaultCacetrafecRepository.getIndicadores();
    //when
    verify(cacetrafecCustomMapper).selectMany(argThat(selectStatment -> {
      //then
      assertThat("select * from cacetrafec where xcacetra = :p1").isEqualTo( selectStatment.getSelectStatement().toLowerCase());
      Map<String, Object> parameters = selectStatment.getParameters();
      assertThat("I").isEqualTo( parameters.get("p1"));
      return true;
    }));
  }

  @Test
  @DisplayName("Probamos que se obtienen los indicadores paginados")
  void givenPageFilters_whenSelectAllIndicadores_thenReturnAllIndicadoresPaged() {
    //given
    defaultCacetrafecRepository.getIndicadores(PageRequest.of(0, 10));
    //when
    verify(cacetrafecCustomMapper).getIndicadoreswithPagination(
      // then
      eq(0L), eq(10));
  }

}
