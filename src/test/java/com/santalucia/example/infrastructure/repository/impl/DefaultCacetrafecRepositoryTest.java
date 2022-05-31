package com.santalucia.example.infrastructure.repository.impl;

import com.santalucia.example.infrastructure.mybatis.primary.custom.CacetrafecCustomMapper;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
  void getIndicadores_ok() {
    defaultCacetrafecRepository.getIndicadores();
    verify(cacetrafecCustomMapper).selectMany(argThat(selectStatment -> {
      assertEquals("select * from cacetrafec where xcacetra = :p1", selectStatment.getSelectStatement().toLowerCase());
      Map<String, Object> parameters = selectStatment.getParameters();
      assertEquals("I", parameters.get("p1"));
      return true;
    }));
  }

  @Test
  void testGetIndicadores_ok() {
    defaultCacetrafecRepository.getIndicadores(PageRequest.of(0, 10));
    verify(cacetrafecCustomMapper).getIndicadoreswithPagination(eq(0L), eq(10));
  }

}
