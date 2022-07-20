package com.santalucia.example.api.delegate;

import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.core.domain.IndicadoresCentroDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.IndicadorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.wildfly.common.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
class DefaultIndicadoresApiDelegateTest {

  @Mock
  IndicadorService indicadorService;

  @Mock
  CacetrafecDomainMapper cacetrafecMapper;

  @Test
  @DisplayName("Dado un contexto de prueba, probamos que respuesta de la llamada a get indicadores list")
  void getIndicadoresList() {
    //given
    DefaultIndicadoresApiDelegate delegate = new DefaultIndicadoresApiDelegate(indicadorService, cacetrafecMapper);
    //when
    when(indicadorService.getIndicadores(any(Pageable.class))).thenReturn(ApiDelegateTestUtils.getIndicadoresList());
    when(cacetrafecMapper.indicadoresDomainToResources(anyList())).thenReturn(ApiDelegateTestUtils.getIndicadoresListResource());
    //then
    CompletableFuture<ResponseEntity<List<IndicadorResource>>> completableFuture =
      delegate.getIndicadoresList(java.util.Optional.empty(), Pageable.ofSize(10));
    assertNotNull(completableFuture);
    assertEquals(200, completableFuture.join().getStatusCodeValue());
    assertEquals(ApiDelegateTestUtils.getIndicadoresListResource(), completableFuture.join().getBody());

    CompletableFuture<ResponseEntity<List<IndicadorResource>>> completableFutureNull =
      delegate.getIndicadoresList(java.util.Optional.empty(),null);
    assertNotNull(completableFutureNull);
    assertEquals(404, completableFutureNull.join().getStatusCodeValue());
    assertNull(completableFutureNull.join().getBody());

  }
}
