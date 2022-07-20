package com.santalucia.example.api.delegate;

import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.IndicadorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.data.domain.Pageable;
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

    when(indicadorService.getIndicadores(any(Pageable.class))).thenReturn(ApiDelegateTestDataFactory.buildIndicadoresList());
    when(indicadorService.getIndicadores(isNull())).thenReturn(null);
    when(cacetrafecMapper.indicadoresDomainToResources(anyList())).thenReturn(ApiDelegateTestDataFactory.buildIndicadoresListResource());

    CompletableFuture<ResponseEntity<List<IndicadorResource>>> completableFuture =
      delegate.getIndicadoresList(java.util.Optional.empty(), Pageable.ofSize(10));
    assertThat(completableFuture).isNotNull();
    assertThat(completableFuture.join().getStatusCodeValue()).isEqualTo(200);
    assertThat(completableFuture.join().getBody()).isEqualTo(ApiDelegateTestDataFactory.buildIndicadoresListResource());

    CompletableFuture<ResponseEntity<List<IndicadorResource>>> completableFutureNull =
      delegate.getIndicadoresList(java.util.Optional.empty(),null);
    assertThat(completableFutureNull).isNotNull();
    assertThat(completableFutureNull.join().getStatusCodeValue()).isEqualTo(404);
    assertThat(completableFutureNull.join().getBody()).isNull();

  }
}
