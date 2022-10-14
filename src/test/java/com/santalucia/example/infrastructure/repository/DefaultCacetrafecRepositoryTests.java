package com.santalucia.example.infrastructure.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.infrastructure.mybatis.primary.custom.CacetrafecCustomMapper;

@ExtendWith(SpringExtension.class)
class DefaultCacetrafecRepositoryTests {

  @InjectMocks
  private DefaultCacetrafecRepository defaultCacetrafecRepository;

  @Mock
  private CacetrafecCustomMapper cacetrafecCustomMapper;

  @Test
  @DisplayName("Probamos que se cargan todos los indicadores cuando no se aplican filtros")
  void givenNoFilterParameters_whenSelectAllIndicadores_thenReturnAllIndicadores() {
    //given
    defaultCacetrafecRepository.getIndicadores();
    //when
    verify(cacetrafecCustomMapper).selectMany(argThat(selectStatment -> {
	    //then
	    assertThat(selectStatment.getSelectStatement().toLowerCase()).isEqualTo("select * from cacetrafec where xcacetra = :p1");
	    Map<String, Object> parameters = selectStatment.getParameters();
	    assertThat(parameters).containsEntry("p1","I");
	    return true;
	    })
    );
  }

  @Test
  @DisplayName("Probamos que se obtienen los indicadores paginados")
  void givenPageFilters_whenSelectAllIndicadores_thenReturnAllIndicadoresPaged() {
    //given
    defaultCacetrafecRepository.getIndicadores(PageRequest.of(0, 10));
    //when
    verify(cacetrafecCustomMapper).getIndicadoreswithPagination(0L, 10);
  }

}
