package com.santalucia.example.api.delegate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.core.domain.IndicadoresCentroDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.IndicadorService;

@ExtendWith(SpringExtension.class)
class DefaultIndicadoresApiDelegateTests {

  @Mock
  IndicadorService indicadorService;

  @Mock
  CacetrafecDomainMapper cacetrafecMapper;

  @Test
  @DisplayName("Dado un contexto de prueba, probamos respuesta de la llamada a get indicadores list")
  void test_indicadores_api_delegate() {
    DefaultIndicadoresApiDelegate delegate = new DefaultIndicadoresApiDelegate(indicadorService, cacetrafecMapper);
    List<IndicadorResource> resources = Instancio.createList(IndicadorResource.class);
    List<IndicadoresCentroDomain> domains = Instancio.createList(IndicadoresCentroDomain.class);


    when(indicadorService.getIndicadores(any(Pageable.class))).thenReturn(domains);
    when(cacetrafecMapper.indicadoresDomainToResources(anyList())).thenReturn(resources);

    CompletableFuture<ResponseEntity<List<IndicadorResource>>> completableFuture =
      delegate.getIndicadoresList(Optional.empty(), Pageable.ofSize(10));

    assertThat(completableFuture).isNotNull();
    assertThat(completableFuture.join().getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(completableFuture.join().getBody()).isEqualTo(resources);

  }
}
