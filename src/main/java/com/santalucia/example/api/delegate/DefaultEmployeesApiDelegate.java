package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.api.server.ListEmployeesApiDelegate;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * DefaultEmployeesApiDelegate
 *
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultEmployeesApiDelegate implements ListEmployeesApiDelegate {

  private final EmployeeService employeeService;
  private final EmployeeDomainMapper employeeMapper;

  /**
   * recupera la lista de empleados
   *
   * @param Optional<UUID> xRequestId
   * @param Pageable       pageable
   * @return ResponseEntity<List <EmployeeResource>>
   */
  @Async
  @Override
  public ResponseEntity<List<EmployeeResource>> getEmployeesList(Optional<UUID> xRequestId, Pageable pageable) {
    log.info("Pageable pagenumber: {} ", pageable.getPageNumber());
    log.info("Pageable pageSize: {} ", pageable.getPageSize());
    log.info("Pageable offset: {} ", pageable.getOffset());

    return Optional
            .of(employeeService.getEmployees(pageable))
            .map(employees -> ResponseEntity.ok()
            .body(employeeMapper.toResources(employees))) // 200 OK
            .orElseGet(() -> ResponseEntity.notFound().build()); // 404 Not found
       
  }
}
