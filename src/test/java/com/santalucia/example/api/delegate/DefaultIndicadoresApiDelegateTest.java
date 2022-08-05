package com.santalucia.example.api.delegate;

import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.IndicadorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class DefaultIndicadoresApiDelegateTest {

  @Mock
  IndicadorService indicadorService;

  @Mock
  CacetrafecDomainMapper cacetrafecMapper;

  @Test
  @DisplayName("Dado un contexto de prueba, probamos respuesta de la llamada a get indicadores list")
  void test_indicadores_api_delegate() {
    DefaultIndicadoresApiDelegate delegate = new DefaultIndicadoresApiDelegate(indicadorService, cacetrafecMapper);
    List<IndicadorResource> response = ApiDelegateTestDataFactory.buildIndicadoresListResource();

    when(indicadorService.getIndicadores(any(Pageable.class))).thenReturn(ApiDelegateTestDataFactory.buildIndicadoresList());
    when(indicadorService.getIndicadores(isNull())).thenReturn(null);
    when(cacetrafecMapper.indicadoresDomainToResources(anyList())).thenReturn(response);

    CompletableFuture<ResponseEntity<List<IndicadorResource>>> completableFuture =
      delegate.getIndicadoresList(java.util.Optional.empty(), Pageable.ofSize(10));
    assertThat(completableFuture).isNotNull();
    assertThat(completableFuture.join().getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(completableFuture.join().getBody()).isEqualTo(response);



  }
}
