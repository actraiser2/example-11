package com.santalucia.example.api.delegate;


import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultEmployeeApiDelegateTest {
  @Mock
  EmployeeService employeeService;
  @Mock
  EmployeeDomainMapper employeeMapper;


  @Test
  @DisplayName("Dado un contexto de prueba, probamos que respuesta lista empleados es correcta")
  void getEmployeesList() {
    DefaultEmployeesApiDelegate delegate = new DefaultEmployeesApiDelegate(employeeService, employeeMapper);

    when(employeeService.getEmployees(any(Pageable.class))).thenReturn(ApiDelegateTestUtils.getListEmployeeDomain());
    when(employeeMapper.toResources(anyList())).thenReturn(ApiDelegateTestUtils.getListEmployeeResource());

    CompletableFuture<ResponseEntity<List<EmployeeResource>>> completableFuture =
      delegate.getEmployeesList(Optional.empty(), Pageable.ofSize(10));

    assertNotNull(completableFuture);
    assertEquals(200, completableFuture.join().getStatusCodeValue());
    assertEquals(ApiDelegateTestUtils.getListEmployeeResource(), completableFuture.join().getBody());


  }
}
