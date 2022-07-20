package com.santalucia.example.api.delegate;


import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class DefaultEmployeeApiDelegateTest {
  @Mock
  EmployeeService employeeService;
  @Mock
  EmployeeDomainMapper employeeMapper;


  @Test
  @DisplayName("Dado un contexto de prueba,  probamos respuesta de la llamada a get employees list")
  void test_employes_delegate() {
    DefaultEmployeesApiDelegate delegate = new DefaultEmployeesApiDelegate(employeeService, employeeMapper);

    when(employeeService.getEmployees(any(Pageable.class))).thenReturn(ApiDelegateTestUtils.buildListEmployeeDomain());
    when(employeeMapper.toResources(anyList())).thenReturn(ApiDelegateTestUtils.buildListEmployeeResource());

    CompletableFuture<ResponseEntity<List<EmployeeResource>>> completableFuture =
      delegate.getEmployeesList(Optional.empty(), Pageable.ofSize(10));
    assertThat(completableFuture).isNotNull();
    assertThat(completableFuture.join().getStatusCodeValue()).isEqualTo(200);
    assertThat(completableFuture.join().getBody()).isEqualTo(ApiDelegateTestUtils.buildListEmployeeResource());


  }
}
