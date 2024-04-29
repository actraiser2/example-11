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

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;

@ExtendWith(SpringExtension.class)
class DefaultEmployeeApiDelegateTests {

  @Mock
  private EmployeeService employeeService;

  @Mock
  private EmployeeDomainMapper employeeMapper;

  @Test
  @DisplayName("Dado un contexto de prueba,  probamos respuesta de la llamada a get employees list")
  void test_employes_delegate() {
    DefaultEmployeesApiDelegate delegate = new DefaultEmployeesApiDelegate(employeeService, employeeMapper);

    List<EmployeeDomain> lstDomain = Instancio.createList(EmployeeDomain.class);
    List<EmployeeResource> lstResource = Instancio.createList(EmployeeResource.class);

    when(employeeService.getEmployees(any(Pageable.class))).thenReturn(lstDomain);
    when(employeeMapper.toResources(anyList())).thenReturn(lstResource);

    CompletableFuture<ResponseEntity<List<EmployeeResource>>> completableFuture =
      delegate.getEmployeesList(Optional.empty(), Pageable.ofSize(10));

    assertThat(completableFuture).isNotNull();
    assertThat(completableFuture.join().getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
    assertThat(completableFuture.join().getBody()).isEqualTo(lstResource);
  }
}
